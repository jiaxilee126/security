package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName ProductCase
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 9:06
 */
@Data
@Entity
@Table(name = "product_case")
public class ProductCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String image;
    private String description;
    private Boolean status;
    private Date createTime;
    private Date updateTime;
}
