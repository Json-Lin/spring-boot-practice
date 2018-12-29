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
public class DataJpaApplicationStarter {

    private static final Log LOG = LogFactory.getLog(DataJpaApplicationStarter.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DataJpaApplicationStarter.class, args);
        LOG.info("spring-boot-practice-data-jpa is started.");
    }
}
