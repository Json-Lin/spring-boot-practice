package com.foo.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@Configuration
public class CustomConfiguration {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    @Bean("dataSource")
    public DataSource druidDataSource(StandardEnvironment env) {
        Properties properties = new Properties();
        DruidDataSource druidDataSource = new DruidDataSource();
        PropertySource<?> appProperties = env.getPropertySources().get("applicationConfig: [classpath:/application.yml]");
        Map<String,Object>  source = (Map<String, Object>) appProperties.getSource();
        properties.putAll(source);
        druidDataSource.configFromPropety(properties);
        druidDataSource.setUrl(url);
        druidDataSource.setPassword(username);
        druidDataSource.setUsername(password);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }
}
