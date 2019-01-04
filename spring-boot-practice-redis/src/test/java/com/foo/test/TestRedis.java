package com.foo.test;

import com.foo.RedisApplicationStarter;
import com.foo.service.RedisCacheService;
import com.foo.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2018/12/28
 */

@SpringBootTest(classes = RedisApplicationStarter.class)
@RunWith(SpringRunner.class)
public class TestRedis {


    @Autowired
    RedisService redisServie;

    @Autowired
    RedisCacheService redisCacheService;

    @Test
    public void lpushValuesTest() {
        redisServie.lpushValues("spring-data-redis", "aaa", "fsd", "45646");
    }

    @Test
    public void lpopTest() {
        redisServie.lpop("spring-data-redis");
    }

    @Test
    public void cacheTest() {
        redisCacheService.getValue("key2");
        redisCacheService.getValue("key1");
        redisCacheService.getValue("key3");
    }
}
