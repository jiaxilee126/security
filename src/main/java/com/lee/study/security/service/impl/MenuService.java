package com.lee.study.security.service.impl;

import com.lee.study.security.dao.ResourceResposity;
import com.lee.study.security.dto.MenuDTO;
import com.lee.study.security.entity.Resource;
import com.lee.study.security.enums.ResourceEnum;
import com.lee.study.security.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MenuService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/28 17:03
 */
@Service
public class MenuService implements IMenuService{
    @Autowired
    private ResourceResposity resourceResposity;

    @Override
    public List<MenuDTO> getPageMenu() {
        List<Resource> resources = resourceResposity.findByType(ResourceEnum.URL.getKey());
        return getMenuDTO4Res(resources);
    }

    /**
     * 获取根目录菜单
     * @param res
     * @return
     */
    public List<MenuDTO> getMenuDTO4Res(List<Resource> res) {
        List<MenuDTO> dtos = new ArrayList<>();
        for (Resource resource: res
             ) {
            //挑出根菜单
            if(resource.getParentId() == 0){
                MenuDTO dto = new MenuDTO(resource);
                dto.setSubMenu(getMenuDTO4ResId(resource.getId()));
                dtos.add(dto);
            }

        }
        return  dtos;
    }

    /**
     * 获取根目录的子菜单
     * @param resourceid
     * @return
     */
    public List<MenuDTO> getMenuDTO4ResId(Integer resourceid) {
        List<MenuDTO> dtos = new ArrayList<>();
        List<Resource> res = resourceResposity.getSubResouces(resourceid);
        for (Resource r : res){
            if(resourceResposity.getSubResouces(r.getId()).size() == 0){
                dtos.add(new MenuDTO(r));
            }else {
                getMenuDTO4ResId(r.getId());
            }
        }
        return dtos;
    }

}
