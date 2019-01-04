package com.foo.service;

import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/1/4
 */
@Service
public class RedisCacheService {

    private static final Log LOG = LogFactory.getLog(RedisCacheService.class);

    private static Map<String,String> DATA_SOURCE = Maps.newHashMap();

    static {
        DATA_SOURCE.put("key1","val1");
        DATA_SOURCE.put("key2","val2");
        DATA_SOURCE.put("key3","val3");
    }

    @Cacheable(cacheNames="spring-chech",key = "#key")
    public String getValue(String key){
        String val = DATA_SOURCE.get(key);
        LOG.info(val);
        return val;
    }
}
