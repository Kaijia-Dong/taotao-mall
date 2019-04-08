package com.taotao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-02 11:47
 **/
@Slf4j
@RestController
public class IndexController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/")
    public String helloWorld() {
        String str = redisTemplate.opsForValue().get("abc").toString();
        if (null == str || str == "") {
            redisTemplate.opsForValue().set("abc","0");
        }
        String a = redisTemplate.opsForValue().get("abc").toString();
        Long b = Long.valueOf(a);
        b+=1;
        redisTemplate.opsForValue().set("abc",String.valueOf(b));
        log.info("test log {}", "helloWorld");
        return "helloWorld";
    }

    @RequestMapping("b")
    public String helloWorldb() {
        String str = stringRedisTemplate.opsForValue().get("stringRedisTemplate");
        if (null == str || str == "") {
            redisTemplate.opsForValue().set("stringRedisTemplate",String.valueOf(0));
        }
        str = stringRedisTemplate.opsForValue().get("stringRedisTemplate");
        Long b = Long.valueOf(str.replaceAll("\"",""));
        b+=1;
        stringRedisTemplate.opsForValue().set("stringRedisTemplate",String.valueOf(b));
        log.info("test log {}", b);
        return String.valueOf(b);
    }

}
