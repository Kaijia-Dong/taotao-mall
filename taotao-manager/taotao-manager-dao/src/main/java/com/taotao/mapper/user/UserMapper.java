package com.taotao.mapper.user;

import com.taotao.pojo.user.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

    @Insert("insert into t_user(username,password) values(#{username},#{password})")
    public int insertUser(User user);
}
