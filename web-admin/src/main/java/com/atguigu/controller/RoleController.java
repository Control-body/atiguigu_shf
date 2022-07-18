package com.atguigu.controller;

import com.atguigu.entity.Role;
import com.atguigu.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.atguigu.constant.PackageConstant.*;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
    @Autowired
    private RoleService roleService;

//    @RequestMapping()
//    public String index(ModelMap model){
////        调用后端得 方法 放到域 中
//        List<Role> all = roleService.findAll();
//        model.addAttribute("list",all);
//        return "role/index";
//    }
    @RequestMapping()
    public String index(ModelMap model, HttpServletRequest request){
        Map<String, Object> filters = getFilters(request);
        PageInfo<Role> page = roleService.findPage(filters);
        model.addAttribute("page", page);
        model.addAttribute("filters", filters);

        return PAGE_INDEX;
    }
    @GetMapping("/create")
    public String  create(){
        return  "role/create";
    }

    @PostMapping("/save")
    public String save(Role role){
        try{
            roleService.insert(role);
        }catch (Exception e){
            e.printStackTrace();
        }
        return PAGE_SUCCESS;
    }
//    修改得方法
    @GetMapping("/edit/{roleId}")
    public String  edit(ModelMap map,@PathVariable("roleId") Integer id){
        Role role = roleService.getById(id);
        map.addAttribute("role" ,role);
        return  PAGE_EDIT;
    }
    @PostMapping("/update")
    public String update(Role role){
        try{
            roleService.update(role);
        }catch (Exception e){
            e.printStackTrace();

        }
        return PAGE_SUCCESS;

    }

//    删除得操作
@GetMapping("/delete")
    public String  delete(Integer id){
            try{
                roleService.delete(Long.valueOf(id));
            }catch (Exception e){
                e.printStackTrace();
            }
    return  LIST_ACTION;
    }
}
