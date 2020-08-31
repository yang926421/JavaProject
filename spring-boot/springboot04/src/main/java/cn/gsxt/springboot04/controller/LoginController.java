package cn.gsxt.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){
        //具体的业务流程
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("msg","登录失败,请重新登录");
            return "index";
        }

    }

}
