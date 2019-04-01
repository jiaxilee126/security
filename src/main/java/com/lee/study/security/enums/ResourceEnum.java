package com.lee.study.security.enums;

import lombok.Data;

/**
 * @ClassName ResourceEnum
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/28 17:05
 */
public enum  ResourceEnum {
    URL(1,"路径"),
    BUTTON(2,"按钮"),
    ;

    private Integer key;
    private String name;
    public Integer getKey() {
        return key;
    }
    public String getName() {
        return name;
    }
    private ResourceEnum(Integer key, String name) {
        this.key = key;
        this.name = name;
    }
}
