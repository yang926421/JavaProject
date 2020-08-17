package cn.gsxt.controller;

import cn.gsxt.domain.Role;
import cn.gsxt.domain.User;
import cn.gsxt.service.RoleService;
import cn.gsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView List(ModelAndView modelAndView){
        //去service层查询
        List<User> userList =  userService.list();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

        //用户点击页面的展示部分数据
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(ModelAndView modelAndView){
        //去service层查询
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds){
        //去service层查询
        userService.save(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
        //去service层查询
        userService.del(userId);
        return "redirect:/user/list";
    }

}
