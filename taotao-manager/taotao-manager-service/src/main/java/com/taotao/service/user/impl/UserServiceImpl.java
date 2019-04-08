package com.taotao.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.user.UserMapper;
import com.taotao.pojo.user.User;
import com.taotao.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-03 15:49
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findAllUser();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo.getList();

    }
}
