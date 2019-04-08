package com.taotao.service.user.impl;

import com.github.pagehelper.PageInfo;
import com.taotao.pojo.user.User;
import com.taotao.service.user.UserService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-08 10:17
 **/
@Service(value = "newUserService")
public class NewUserServiceImpl implements UserService {

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        return null;
    }
}
