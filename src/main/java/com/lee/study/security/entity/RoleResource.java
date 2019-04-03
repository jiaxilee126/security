package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName RoleResource
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 16:59
 */
@Data
@Table(name = "role_resource")
@Entity
public class RoleResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer roleId;
    private Integer resourceId;
    private Date createTime;
    private Date updateTime;


}
