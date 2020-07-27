package cn.gsxt.servlet;

import cn.gsxt.domain.User;
import cn.gsxt.service.impl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据ID获取到这个user对象，转发给update.jsp
        String id = request.getParameter("id");
        //使用service去查询
        userServiceImpl service = new userServiceImpl();
        User user  =   service.findUserById(Integer.parseInt(id));
        //将user存入到request域中
        request.setAttribute("user", user);
        //将这个user转发update.jsp页面中， 可以共享request域
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
