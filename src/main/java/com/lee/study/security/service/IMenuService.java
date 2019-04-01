package com.lee.study.security.service;

import com.lee.study.security.dto.MenuDTO;

import java.util.List;

/**
 * @ClassName IMenuService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/28 16:59
 */
public interface IMenuService {
    List<MenuDTO> getPageMenu();
}
