package cn.gsxt.servlet;

import cn.gsxt.domain.User;
import cn.gsxt.service.impl.userServiceImpl;
import cn.gsxt.service.userService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("进入loginServlet");
        //获取数据
        String verifycode = request.getParameter("verifycode");
        //校验验证码，拿到生成验证码的时候存进session的值
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //获取完之后就删除这个属性，来确保验证码一次性
        session.removeAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确，提示信息，跳转登陆
            request.setAttribute("login_msg", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;

        }
        //获取到这个map集合。封装BeanUserd的用户名和密码
        Map<String, String[]> map = request.getParameterMap();
        //4.封装User对象
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
//        try {
//            BeanUtils.populate(user,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        //查询
        userService service = new userServiceImpl();
        //判断是否登陆成功
        User loginUser = service.login(user);
        if (loginUser != null) {
            //登陆成功,将用户数据存入session
            session.setAttribute("user", loginUser);

            response.sendRedirect(request.getContextPath() + "/index.jsp");

        } else {
            //登陆失败，跳转登陆界面
            request.setAttribute("login_msg", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
