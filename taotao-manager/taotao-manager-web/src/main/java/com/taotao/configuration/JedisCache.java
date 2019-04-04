package com.taotao.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-04 18:16
 **/
@Component
public class JedisCache {

    @Autowired
    JedisPool jedisPool;

}
