package cn.gsxt.interceptor;

import cn.gsxt.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeInter implements HandlerInterceptor {
    //复写三个方法

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录(session中有没有当前user)
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            //没有登录
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            //代表不放行,不能访问目标资源
            return false;
        }
        //放行
        return true;
    }
}
