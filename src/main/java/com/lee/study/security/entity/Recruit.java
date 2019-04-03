package com.lee.study.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Recruit
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 9:06
 */
@Data
@Entity
@Table(name = "recruit")
public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean status;
    private Date createTime;
    private Date updateTime;
}
