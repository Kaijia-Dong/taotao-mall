package com.taotao.controller;

import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping("/")
    public String helloWorld() {
        log.info("test log {}", "helloWorld");
        return "helloWorld";
    }

}
