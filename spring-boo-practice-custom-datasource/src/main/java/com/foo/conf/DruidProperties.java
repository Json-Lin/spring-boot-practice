package com.foo.conf;

import java.io.Serializable;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
public class DruidProperties implements Serializable{
    private static final long serialVersionUID = -7706733742265119314L;

    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private String filters;
    private int maxActive;
//    initialSize: 1
//    maxWait: 30000
//    minIdle: 10
//    maxIdle: 15
//    timeBetweenEvictionRunsMillis: 60000
//    minEvictableIdleTimeMillis: 300000
//    validationQuery: SELECT 1
//    testWhileIdle: true
//    testOnBorrow: false
//    testOnReturn: false
//    maxOpenPreparedStatements: 20
//    removeAbandoned: true
//    removeAbandonedTimeout: 1800
//    logAbandoned: true
}
