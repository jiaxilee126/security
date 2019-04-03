package com.lee.study.security.dto;

import com.lee.study.security.entity.Resource;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MenuDTO
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/28 16:59
 */
@Data
public class MenuDTO {
    private String name;
    private String type;
    private String url;
    private Integer parentId;
    private Integer sort;
    private String icon;
    private Date createtime;
    private Date updatetime;

    private List<MenuDTO> subMenu;

    public MenuDTO(Resource resource){
        this.name = resource.getName();
        this.type = resource.getType();
        this.url = resource.getUrl();
        this.parentId = resource.getParentId();
        this.sort = resource.getSorted();
        this.icon = resource.getIcon();
        this.createtime = resource.getCreateTime();
        this.updatetime = resource.getUpdateTime();
    }

}
