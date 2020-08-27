package cn.gsxt.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    @Override
    //在目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("之前执行");
        String param = request.getParameter("param");
        if ("yes".equals(param)) {
            return true;
        } else {
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
            return false;
        }
        //代表之后的要不要放行,true放行,是否允许访问目标资源
    }

    @Override
    //目标方法执行之后,视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("之后执行");
        modelAndView.addObject("name", "lyyhht");
    }

    @Override
    //整个流程都执行完之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("最后执行");
    }
}
