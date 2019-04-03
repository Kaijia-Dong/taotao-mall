package com.taotao.service.user;

import com.github.pagehelper.PageInfo;
import com.taotao.pojo.user.User;

public interface UserService {

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);

}
