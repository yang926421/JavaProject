package cn.gsxt.asb.web.servlet;

import cn.gsxt.asb.dao.userDao;
import cn.gsxt.asb.domain.user;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      /* //2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        //3.封装user对象
        user loginUser = new user();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        //1.设置编码
//        request.setCharacterEncoding("utf-8");
//        Map<String, String[]> map = request.getParameterMap();
//        user user = new user();
//        try {
//            BeanUtils.populate(user,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        //调用userDao的登陆方法
        System.out.println(23456);
        userDao dao = new userDao();
        System.out.println(12345);
//        request.getRequestDispatcher("/SuccessServlet").forward(request,response);
        user user = dao.login(loginUser);
        System.out.println(user);
        //判断
        //5.判断user
        if(user == null){
            //登录失败
            request.getRequestDispatcher("/FailServlet").forward(request,response);
        }else{
            //登录成功
            //存储数据
            request.setAttribute("user",user);
            //转发
            request.getRequestDispatcher("/SuccessServlet").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
