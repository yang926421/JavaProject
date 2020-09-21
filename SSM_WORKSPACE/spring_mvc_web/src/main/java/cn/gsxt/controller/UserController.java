package cn.gsxt.controller;

import cn.gsxt.domain.User;
import cn.gsxt.domain.VoResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller save running");
        return "success";
    }

//    @RequestMapping("/quick1")
//    public String save1(){
//        System.out.println("Controller1 save running");
//        return "redirect:/success.jsp";
//    }

    @RequestMapping("/quick2")
    public ModelAndView save2() {
        System.out.println("Controller2 save running");
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username", "zhangSan");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    //SpringMvc对对应的方法的参数可以进行注入,解析的时候发现这个参数需要mvc提供,会传给个实参
    public ModelAndView save3(ModelAndView modelAndView) {
        System.out.println("Controller3 save running");
        //设置模型数据
        modelAndView.addObject("username", "lisi");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model) {
        System.out.println("Controller4 save running");
        model.addAttribute("username", "wangwu");
        return "success";
    }

    @RequestMapping("/quick5")
    //HttpServletRequest request   因为用框架了 就是为了解耦,所以尽量不会web阶段的servlet的相关API使用
    public String save5(HttpServletRequest request) {
        System.out.println("Controller5 save running");
        request.setAttribute("username", "username");
        return "success";
    }

    @RequestMapping("/quick6")
    //回写数据
    public void save6(HttpServletResponse response) throws Exception {
        System.out.println("Controller6 save running");
        response.getWriter().println("hello lyy");
    }

    @RequestMapping("/quick7")
    //回写数据
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体
    public String save7() throws Exception {
        System.out.println("Controller7 save running");
        return "hello lyy";
    }

    @RequestMapping("/quick8")
    //回写数据
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
    public String save8() throws Exception {
        System.out.println("Controller8 save running");
        return "hello lyy";
    }

    @RequestMapping("/quick9")
    //回写数据
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
    public String save9() throws Exception {
        System.out.println("Controller9 save running");
        //返回json格式的字符串
        return "{\"username\":\"zhangsan\"}";
    }

    @RequestMapping("/quick10")
    //回写数据
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
    public String save10() throws Exception {
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
    public User save11() throws Exception {
        System.out.println("Controller11 save running");
        //返回json格式的字符串
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器
        return user;
    }

    @RequestMapping("/quick12")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick12?username=zhangsan&&age=12
//    获取请求参数   直接形参匹配
    public void save12(String username, int age) throws Exception {
        System.out.println("Controller12 save running");
        System.out.println(username);
        System.out.println(age);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器



    }

    @RequestMapping("/quick13")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick13?username=zhangsan&&age=12
//    获取请求参数   参数的属性名与请求参数的name一致,参数会自动映射匹配
    public void save13(User user) throws Exception {
        System.out.println("Controller13 save running");
        System.out.println(user.getUsername());
        System.out.println(user.getAge());
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick14")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick14?strs=111&&strs=222&&strs=333
//    获取数组类型的请求参数   参数的属性名与请求参数的name一致,参数会自动映射匹配
    public void save14(String[] strs) throws Exception {
        System.out.println("Controller14 save running");
        System.out.println(Arrays.asList(strs));
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick15")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    form表单提交的数据  form.jsp  获取集合类型的请求参数 需要放入一个Vo对象中   valueResult  参数的属性名与请求参数的name一致,参数会自动映射匹配
    public void save15(VoResult voResult) throws Exception {
        System.out.println("Controller15 save running");
        System.out.println(voResult);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick16")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    ajax请求的数据,详见ajax.jsp
    public void save16(@RequestBody List<User> userList) throws Exception {
        System.out.println("Controller16 save running");
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器
        System.out.println(userList);

    }


    //    @RequestParam(重点,重点,重点)
    @RequestMapping("/quick17")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick17?name=zhangsan
//    将url请求的参数  name绑定为当前方法形参的username
    //required=false   url请求的参数name可以不写  配置default默认参数为lyy
    public void save17(@RequestParam(value = "name", required = false, defaultValue = "lyy") String username) throws Exception {
        System.out.println("Controller17 save running");
        System.out.println(username);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick18/{username}")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick17/zhangsan   使用restful规范
    //@PathVariable("username") 获取到restful的requestMapping的username
    public void save18(@PathVariable("username") String username) throws Exception {
        System.out.println("Controller18 save running");
        System.out.println(username);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick19")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick19/  使用restful规范
    //如果是2020/9/20   可以转换  如果是   2020-9-20则不可以转换  需要自定义类型转换器
    public void save19(Date date) throws Exception {
        System.out.println("Controller19 save running");
        System.out.println(date);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick20")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick20
    public void save20(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        System.out.println("Controller20 save running");
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick21")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick21
    public void save21(@RequestHeader(value = "User-Agent", required = false) String user_agent) throws Exception {
        System.out.println("Controller21 save running");
        System.out.println(user_agent);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick22")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/spring_mvc_web/user/quick22
    public void save22(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) throws Exception {
        System.out.println("Controller22 save running");
        System.out.println(jsessionId);
        //配置声明 mvc声明  自动转化为json  配置转换器的时候指定json转换的转换器(详见spring-mvc.xml mvc配置中的)
        //注入json的一个转换器

    }

    @RequestMapping("/quick23")
    //回写数据(返回对象或集合  不自己转json  使用MVC配置的)
    @ResponseBody  //告诉SpringMVC这是为了回写字符串,不是进行跳转的  直接在Http响应体回写(重点 重点)
//    http://localhost:8080/upload.jsp   upload.jsp  input file的名称必须和这个一致
    public void save23(String name, MultipartFile[] uploadFile) throws Exception {
        System.out.println("Controller23 save running");
        System.out.println(name);
//        System.out.println(uploadFile);
        //多文件上传  服务端用数组接收
        for (MultipartFile multipartFile : uploadFile) {
            //保存文件,放到服务器磁盘中(先获取名称)
            String filename = multipartFile.getOriginalFilename();
            //后期都是保存在服务器中的某个地址
            multipartFile.transferTo(new File("D:\\lyy\\" + filename));
        }


    }


}
