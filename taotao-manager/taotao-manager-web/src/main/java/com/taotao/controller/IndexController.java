package com.taotao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-02 11:47
 **/
@RestController
public class IndexController {

    @RequestMapping("/")
    public String helloWorld() {
        return "helloWorld";
    }

}
