package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName AdminRole
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:16
 */
@Data
@Entity
@Table(name = "admin_role")
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer adminId;
    private Integer roleId;
    private Date createTime;
    private Date updateTime;

}
