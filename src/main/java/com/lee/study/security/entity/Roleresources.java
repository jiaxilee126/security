package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Roleresources
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 16:59
 */
@Data
@Table(name = "roleresources")
@Entity
public class Roleresources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer roleid;
    private Integer resourcesid;
    private Date createtime;
    private Date updatetime;


}
