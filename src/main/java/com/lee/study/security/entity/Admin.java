package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName Admin
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:09
 */
@Data
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String mobile;
}
