package com.taotao.pojo.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-03 15:47
 **/
@Data
@Table(name = "t_user")
public class User {

    @Id
    private Long id;

    @Column
    @NotBlank(message = "用户不能为空")
    private String username;

    @Column
    @NotBlank(message = "密码不能为空")
    private String password;

}
