package com.lee.study.security.controller;

import com.lee.study.security.dao.ResourceResposity;
import com.lee.study.security.dto.MenuDTO;
import com.lee.study.security.entity.Resources;
import com.lee.study.security.entity.User;
import com.lee.study.security.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/25 15:10
 */
@Controller
public class RenderController {
    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = {"/login","/"})
    public String home(User user) {

        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    public String test() {
        return  "test";
    }

    @ModelAttribute("menus")
    public List<MenuDTO> getMenu() {
        return menuService.getPageMenu();
    }
}
