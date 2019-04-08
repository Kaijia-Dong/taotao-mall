package com.taotao.controller.user;

import com.taotao.pojo.user.User;
import com.taotao.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-03 15:53
 **/
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("add")
    public int addUser(@Valid User user) {
        return userService.addUser(user);
    }

}
