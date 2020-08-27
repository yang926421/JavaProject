package cn.gsxt.controller;

import cn.gsxt.domain.Role;
import cn.gsxt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView list(ModelAndView modelAndView) {
        //从service查询
        List<Role> roleList = roleService.list();
        for (Role role : roleList) {
            System.out.println(role.getRoleName());
        }
        System.out.println(roleList);
        modelAndView.addObject("roleList", roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;

    }

    @RequestMapping("/save")
    //springMVC接收到的参数会自动封装到role
    public String save(Role role) {
        //保存操作
        roleService.save(role);
        return "redirect:/role/list";

    }

    @RequestMapping("/target")
    public ModelAndView show() {
        System.out.println("目标资源执行......");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "itcast");
        modelAndView.setViewName("index");
        return modelAndView;
    }


}
