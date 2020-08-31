package cn.gsxt.springboot03.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class PublishInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(PublishInterceptor.class);

    public PublishInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean permission = true;
        String token = request.getParameter("TOKEN");
        log.info("请求过来的api地址>>> {}", request.getRequestURI());
        log.debug("================ access_token：" + token + "\t面向公网的公示信息拦截器");
        return permission;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
