package com.taotao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    JedisPool jedisPool;

    @RequestMapping("/")
    public String helloWorld() {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.get("abc");
        if (null == str || str == "") {
            jedis.set("abc","0");
        }
        Long a = Long.valueOf(jedis.get("abc"));
        a+=1;
        jedis.set("abc",String.valueOf(a));
        jedis.close();
        log.info("test log {}", "helloWorld");
        return "helloWorld";
    }

}
