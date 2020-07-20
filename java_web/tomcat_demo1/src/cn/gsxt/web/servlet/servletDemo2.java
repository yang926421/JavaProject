package cn.gsxt.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class servletDemo2 implements Servlet {
    @Override
    //初始化方法  执行 只会执行一次
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我只会执行一次哦");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    //执行多次  每一次被访问的时候都执行一次
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("这是个什么鬼啊");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    //服务器正常关闭的时候执行一次
    public void destroy() {

    }
}
