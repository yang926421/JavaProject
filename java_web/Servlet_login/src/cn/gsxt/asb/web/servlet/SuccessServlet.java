package cn.gsxt.asb.web.servlet;

import cn.gsxt.asb.domain.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("登陆成功，欢迎登陆");
        //获取request域中共享的user对象
//        user user = (user)request.getAttribute("loginUser");
//        if(user != null)
//        {
//            //设置编码
//            response.setContentType("text/html;character=utf-8");
//            response.getWriter().write("登陆成功，欢迎登陆");
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
