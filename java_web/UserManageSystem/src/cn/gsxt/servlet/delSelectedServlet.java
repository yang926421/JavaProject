package cn.gsxt.servlet;

import cn.gsxt.service.impl.userServiceImpl;
import cn.gsxt.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class delSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除选中的
        System.out.println(124);
        System.out.println(request.getParameter("uid"));
        String[] ids = request.getParameterValues("uid");
        System.out.println(ids);
        //调用service
        userService service = new userServiceImpl();
        service.delSelectedUser(ids);
        response.sendRedirect(request.getContextPath() + "/userListServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
