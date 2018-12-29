package com.foo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2018/12/29
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void lpushValues(String key, String... value) {
        stringRedisTemplate.opsForList().leftPushAll(key, value);
    }

    public void lpush(String key, String value) {
        stringRedisTemplate.opsForList().leftPush(key, value);
    }

    public void lpop(String key) {
        stringRedisTemplate.opsForList().leftPop(key);
    }
}
