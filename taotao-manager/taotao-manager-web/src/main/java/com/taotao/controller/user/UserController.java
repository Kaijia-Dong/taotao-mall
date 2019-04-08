package com.taotao.controller.user;

import com.taotao.pojo.user.User;
import com.taotao.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

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

    @ResponseBody
    @RequestMapping("all")
    public List<User> allUser(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return userService.findAllUser(pageNum, 10);
    }
}
