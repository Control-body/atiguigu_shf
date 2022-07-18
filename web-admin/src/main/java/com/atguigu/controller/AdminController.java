package com.atguigu.controller;

import com.atguigu.entity.Admin;
import com.atguigu.service.AdminService;
import com.atguigu.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    AdminService adminService;
    private final static String LIST_ACTION = "redirect:/admin";
    private final static String PAGE_INDEX = "admin/index";
    private final static String PAGE_CREATE = "admin/create";
    private final static String PAGE_EDIT = "admin/edit";
    private final static String PAGE_SUCCESS = "common/successPage";
    @RequestMapping()
    public String index (ModelMap map, HttpServletRequest request){
        Map<String, Object> filters = getFilters(request);
        PageInfo<Admin> page = adminService.findPage(filters);
        map.addAttribute("page",page);
        map.addAttribute("filters",filters);
        return PAGE_INDEX;
    }
    @RequestMapping("/create")
    public  String create(){
        return PAGE_CREATE;
    }
    @RequestMapping("/save")
    public String save(Admin admin){
        admin.setHeadUrl("https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
        Integer insert = adminService.insert(admin);
        return PAGE_SUCCESS;
    }
    @RequestMapping("/edit/{id}")
    public String edit(ModelMap map, @PathVariable Long id){
        Admin admin = adminService.getById(id);
        map.addAttribute("admin",admin);
        return PAGE_EDIT;
    }
    @RequestMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        adminService.delete(id);
        return LIST_ACTION;
    }
    @RequestMapping("/update")
    public String update(Admin admin){
        Integer update = adminService.update(admin);
        return PAGE_SUCCESS;
    }

}
