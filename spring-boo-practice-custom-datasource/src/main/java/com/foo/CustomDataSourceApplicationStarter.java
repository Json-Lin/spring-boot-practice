package com.foo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/01
 */
@SpringBootApplication
public class CustomDataSourceApplicationStarter {

    private static final Log LOG = LogFactory.getLog(CustomDataSourceApplicationStarter.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CustomDataSourceApplicationStarter.class, args);
        LOG.info("spring-boot-practice-data-custom-datasource is started.");
    }
}
