package cn.gsxt.servlet;

import cn.gsxt.domain.PageBean;
import cn.gsxt.domain.User;
import cn.gsxt.service.impl.userServiceImpl;
import cn.gsxt.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求页码数和条数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "1".equals(currentPage)){

                currentPage = "1";


        }


        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        System.out.println(currentPage);
        System.out.println(rows);
        //创建service
        userService service = new userServiceImpl();
        PageBean<User> pb =  service.findUserByPages(currentPage, rows);
        //调用service去数据库查询
        //将pageBean存到request中
        request.setAttribute("pb", pb);
        System.out.println(pb);
        //转发jsp展示
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
