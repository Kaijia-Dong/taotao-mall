package com.taotao.service.user;

import com.taotao.pojo.user.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    Boolean refreshRedis();

}
