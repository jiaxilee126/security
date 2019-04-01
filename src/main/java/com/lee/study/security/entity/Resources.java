package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Resources
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 17:00
 */
@Data
@Entity
@Table(name = "resources")
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String url;
    private String permission;
    private Integer parentid;
    private Integer sort;
    private String icon;
    private Date createtime;
    private Date updatetime;

}
