package com.foo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleApplicationStarter {

    private static final Log LOG = LogFactory.getLog(SimpleApplicationStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplicationStarter.class, args);
        LOG.info("spring-boot-practice is started.");
    }
}
