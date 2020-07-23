package cn.gsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //先判断验证码是否正确
        HttpSession session = request.getSession();
        String checkCode_session =  (String)session.getAttribute("checkCode_session");
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            //忽略大小写比较 验证码正常
            if("zhangsan".equals(username) && "123".equals(password)){
                //登录成功
                //存储信息 用户信息
                session.setAttribute("user", username);
                System.out.println(request.getContextPath());
                //重定向到success.jsp中
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }
            else{
                //登录失败
                //存储信息到request
                request.setAttribute("login_error", "用户名或密码正确");
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
        else{
            //验证码不一致
            request.setAttribute("cc_error", "验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
