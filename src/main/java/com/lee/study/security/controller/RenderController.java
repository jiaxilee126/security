package com.lee.study.security.controller;

import com.lee.study.security.dto.MenuDTO;
import com.lee.study.security.entity.Admin;
import com.lee.study.security.service.ICaseService;
import com.lee.study.security.service.IMenuService;
import com.lee.study.security.service.IProductService;
import com.lee.study.security.service.IRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @Autowired
    private ICaseService caseService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IRecruitService recruitService;

    @RequestMapping(value = {"/login","/"})
    public String home(Admin admin) {

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

    @RequestMapping("/admin")
    public String admin(){
        return "/page/adminmng/user";
    }

    @RequestMapping("/role")
    public String role() {
        return "/page/adminmng/role";
    }

    @RequestMapping("/menu")
    public String menu() {
        return "/page/adminmng/menu";
    }

    public String test() {
        return  "test";
    }

    @RequestMapping("/recruit")
    public String recruit(Model model) {
        model.addAttribute("recruit", recruitService.getList());
        return "/page/home/recruit";
    }

    @RequestMapping("/product")
    public String product(Model model) {
        model.addAttribute("product", productService.getList());
        return "/page/home/product";
    }

    @RequestMapping("/case")
    public String productCase(Model model) {
        model.addAttribute("productCase", caseService.getList());
        return "/page/home/case";
    }

    @ModelAttribute("menus")
    public List<MenuDTO> getMenu() {
        return menuService.getPageMenu();
    }
}
