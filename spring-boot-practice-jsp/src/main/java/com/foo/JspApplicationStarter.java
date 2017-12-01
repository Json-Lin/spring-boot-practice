package com.foo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/11/30
 */
@SpringBootApplication
public class JspApplicationStarter extends SpringBootServletInitializer {

    private static final Log LOG = LogFactory.getLog(JspApplicationStarter.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JspApplicationStarter.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JspApplicationStarter.class, args);
        LOG.info("spring-boot-practice-jsp is started.");
    }
}
