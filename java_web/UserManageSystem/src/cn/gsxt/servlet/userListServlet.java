package cn.gsxt.servlet;

import cn.gsxt.domain.User;
import cn.gsxt.service.impl.userServiceImpl;
import cn.gsxt.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用userService完成查询
        userService service = new userServiceImpl();
        List<User> users = service.findAll();
        //将list数据存储在request域中
        request.setAttribute("users", users);
        System.out.println(users);
        //转发到jsp页面
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
