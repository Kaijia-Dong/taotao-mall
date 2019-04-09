package com.taotao.service.user.impl;

import com.taotao.pojo.user.User;
import com.taotao.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> findAllUser(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Boolean refreshRedis() {
        return null;
    }
}
