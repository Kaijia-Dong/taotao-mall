package com.taotao.mapper.user;

import com.taotao.pojo.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Insert("insert into t_user(username,password) values(#{username},#{password})")
    int insertUser(User user);

    @Select("select * from t_user")
    List<User> findAllUser();
}
