package com.taotao.controller;

import com.taotao.common.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("helloWorld")
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

    @RequestMapping("test-redis-lock")
    public String testRedisLock() {
        RedisLock lock = new RedisLock(redisTemplate, "account:1", 10000, 20000);
        try {
            if (lock.lock()) {
                log.info("已上锁，请打断点查看REDIS");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //为了让分布式锁的算法更稳键些，持有锁的客户端在解锁之前应该再检查一次自己的锁是否已经超时，再去做DEL操作，因为可能客户端因为某个耗时的操作而挂起，
            //操作完的时候锁因为超时已经被别人获得，这时就不必解锁了。 ————这里没有做
            lock.unlock();
        }
        return "test-redis-lock";
    }
}
