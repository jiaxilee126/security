package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Resource
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 17:00
 */
@Data
@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String url;
    private String permission;
    private Integer parentId;
    private Integer sorted;
    private String icon;
    private Date createTime;
    private Date updateTime;

}
