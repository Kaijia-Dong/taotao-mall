package com.taotao.pojo.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String username;

    @Column
    private String password;

}
