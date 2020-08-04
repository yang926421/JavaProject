package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    //
    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //验证校验
        String check = request.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            ResultInfo info = new ResultInfo();
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        //定义过滤器来处理响应编码的格式，所以不需要再设置编码
        //获取ajax提交的数据，调用service层定义的方法
        Map<String, String[]> map = request.getParameterMap();
        //获取到map集合之后，封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //封装user对象之后，去使用service调用dao层对数据进行交互
        UserServiceImpl service = new UserServiceImpl();
        Boolean flag = service.register(user);
        //resultInfo用来封装后端返回的信息
        ResultInfo info = new ResultInfo();
        if (flag){
            //注册成功
            info.setFlag(true);
        }
        else{
            info.setFlag(false);
            info.setErrorMsg("注册失败，请重新尝试");
        }
        //将info数据序列化为json,然后返回给前端
        ObjectMapper mapper = new ObjectMapper();
        String json_info = mapper.writeValueAsString(info);
        //设置content-type将json数据返回,获取response的输出流
        response.setContentType("application/json;character=utf-8");
        response.getWriter().write(json_info);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("跳转登陆servlet");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用service查询
        UserService service = new UserServiceImpl();
        User u =  service.login(user);
        System.out.println(u.getName());
        System.out.println(u==null);
        System.out.println(u.getStatus());
        ResultInfo info = new ResultInfo();
        //判断用户名或密码是否正确
        if(u==null){
            //用户名密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        //判断用户是否激活
        if(u!=null && !u.getStatus().equals("Y")){
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("尚未激活,请登录邮箱激活");

        }
        //登录成功的判断
        if(u!=null && "Y".equals(u.getStatus())){
            info.setFlag(true);
        }
        //响应数据给前端
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;character=utf-8");
//        mapper.writeValue(response.getOutputStream(), info);
        //在BaseServlet封装了方法json功能
        writeValue(info,response);
    }

    public void active(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //1.获取激活码
        String code = request.getParameter("code");
        if(code != null){
            //2.调用service完成激活
            UserService service = new UserServiceImpl();
            System.out.println(code);
            boolean flag = service.active(code);

            //3.判断标记
            String msg = null;
            if(flag){
                //激活成功
                msg = "激活成功，请<a href='login.html'>登录</a>";
            }else{
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }

    }

    public void exit(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("跳转推出界面");
        //销毁session中的user
        request.getSession().invalidate();
        System.out.println("destoryUser");
        //跳转页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    //从session中获取user对象
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //从session中获取user对象
        System.out.println(123456);
        //从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        //将user写回客户端

//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(),user);
        writeValue(user, response);
    }

}
