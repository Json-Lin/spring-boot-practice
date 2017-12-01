package com.foo.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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

    @Bean("dataSource")
    public DataSource druidDataSource(StandardEnvironment env) {
        Properties properties = new Properties();
        DruidDataSource druidDataSource = new DruidDataSource();
        PropertySource<?> appProperties = env.getPropertySources().get("applicationConfig: [classpath:/application.yml]");
        Map<String,Object>  source = (Map<String, Object>) appProperties.getSource();
        properties.putAll(source);
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }
}
