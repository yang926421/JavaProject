package cn.gsxt.controller;

import cn.gsxt.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/quick")
    public String save(){
        System.out.println("Controller save running");
        return "success";
    }

//    @RequestMapping("/quick1")
//    public String save1(){
//        System.out.println("Controller1 save running");
//        return "redirect:/success.jsp";
//    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
        System.out.println("Controller2 save running");
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","zhangSan");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    //SpringMvc对对应的方法的参数可以进行注入,解析的时候发现这个参数需要mvc提供,会传给个实参
    public ModelAndView save3(ModelAndView modelAndView){
        System.out.println("Controller3 save running");
        //设置模型数据
        modelAndView.addObject("username","lisi");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/quick4")
    public String save4(Model model){
        System.out.println("Controller4 save running");
        model.addAttribute("username","wangwu");
        return "success";
    }

    @RequestMapping("/quick5")
    //HttpServletRequest request   因为用框架了 就是为了解耦,所以尽量不会web阶段的servlet的相关API使用
    public String save5(HttpServletRequest request){
        System.out.println("Controller5 save running");
        request.setAttribute("username","username");
        return "success";
    }

    @RequestMapping("/quick6")
    //回写数据
    public void save6(HttpServletResponse response)throws Exception{
        System.out.println("Controller6 save running");
        response.getWriter().println("hello lyy");
    }

    @RequestMapping("/quick7")
    //回写数据
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体
    public String save7()throws Exception{
        System.out.println("Controller7 save running");
        return "hello lyy";
    }

    @RequestMapping("/quick8")
    //回写数据
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
    public String save8()throws Exception{
        System.out.println("Controller8 save running");
        return "hello lyy";
    }

    @RequestMapping("/quick9")
    //回写数据
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
    public String save9()throws Exception{
        System.out.println("Controller9 save running");
        //返回json格式的字符串
        return "{\"username\":\"zhangsan\"}";
    }

    @RequestMapping("/quick10")
    //回写数据
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
    public String save10()throws Exception{
        System.out.println("Controller10 save running");
        //返回json格式的字符串
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        //将user对象转换  使用json转换工具
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick11")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
    public User save11()throws Exception{
        System.out.println("Controller11 save running");
        //返回json格式的字符串
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器
        return user;
    }




}
