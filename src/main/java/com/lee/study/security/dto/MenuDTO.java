package com.lee.study.security.dto;

import com.lee.study.security.entity.Resources;
import lombok.Data;
import org.springframework.beans.BeanUtils;

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
    private Integer parentid;
    private Integer sort;
    private String icon;
    private Date createtime;
    private Date updatetime;

    private List<MenuDTO> subMenu;

    public MenuDTO(Resources resources){
        this.name = resources.getName();
        this.type = resources.getType();
        this.url = resources.getUrl();
        this.parentid = resources.getParentid();
        this.sort = resources.getSort();
        this.icon = resources.getIcon();
        this.createtime = resources.getCreatetime();
        this.updatetime = resources.getUpdatetime();
    }

}
