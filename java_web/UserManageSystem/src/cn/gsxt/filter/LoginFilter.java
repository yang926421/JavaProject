package cn.gsxt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//完成登陆验证的过滤器
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //获取资源的请求路径，因为是参数时servletRequest,所以需要进行类型强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //获取资源请求路径
        String uri = request.getRequestURI();
        System.out.println(uri);
        //判断请求资源路径包含登陆相关的资源路径
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")) {
            //包含这些信息，用户就是想登陆，放行
            System.out.println("用户就是要登陆");
            chain.doFilter(req, resp);
        } else {
            //不包含，需要验证是否已经登陆
            // 从session获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                System.out.println(123456);
                chain.doFilter(req, resp);
            } else {
                //没有登陆，跳转登陆界面
                System.out.println("跳转登陆界面");
                request.setAttribute("login_msg", "尚未登陆，请先进性登陆");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);

            }
        }
//        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
