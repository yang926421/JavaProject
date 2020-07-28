package cn.gsxt.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//浏览器直接请求资源时，该过滤器会执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)
@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)
public class FilterDemo4 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo4被执行呀");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
