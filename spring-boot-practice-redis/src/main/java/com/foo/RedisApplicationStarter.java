package com.foo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/11/30
 */
@EnableCaching
@SpringBootApplication
public class RedisApplicationStarter {

    private static final Log LOG = LogFactory.getLog(RedisApplicationStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(RedisApplicationStarter.class, args);
        LOG.info("spring-boot-practice-redis is started.");
    }
}
