package com.foo.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/7/24
 */
@Configuration
public class QueueConfiguration {

    @Value("${test.queue.name}")
    private String queueName;

    @Bean
    public Queue sampleQueue() {
        return new ActiveMQQueue(queueName);
    }

}
