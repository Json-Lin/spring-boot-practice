package com.foo.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/4
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "druid")
public class DruidDataSourceProperties {
    private String filters;
    private int maxActive;
    private int initialSize;
    private int maxWait;
    private int minIdle;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private int maxOpenPreparedStatements;
    private boolean removeAbandoned;
    private int removeAbandonedTimeout;
    private boolean logAbandoned;
}
