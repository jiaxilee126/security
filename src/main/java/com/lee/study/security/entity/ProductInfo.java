package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName ProductInfo
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 9:06
 */
@Data
@Entity
@Table(name = "product_info")
public class ProductInfo {

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
