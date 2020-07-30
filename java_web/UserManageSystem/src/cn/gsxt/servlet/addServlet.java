package cn.gsxt.servlet;

import cn.gsxt.domain.User;
import cn.gsxt.service.impl.userServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        //获取到提交的数据
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        调用service的addOne添加数据
        userServiceImpl service = new userServiceImpl();
        service.addOne(user);
//        System.out.println(user1);

        //跳转到userListServer
        response.sendRedirect(request.getContextPath()+"/userListServlet");
        //如果没有注册过,就将submit提交的数据存储到数据库中


//        request.setAttribute("user", user);



        //调用userService完成查询
//        userService service = new userServiceImpl();
//        List<User> users = service.findAll();
//        //将list数据存储在request域中
//        request.setAttribute("users", users);
//        //转发到jsp页面
//        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
