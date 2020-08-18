package cn.gsxt.resolve;

import cn.gsxt.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyResolveException implements HandlerExceptionResolver {
   //继承然后重写resolveException异常
    /*
    参数Exception  异常对象
    返回值 modelAndView跳转到的错误视图信息
    * */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        //这块儿的逻辑只是为了证明可以获得相应的异常,进行判断
        if (e instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }
        else if(e instanceof ClassCastException){
        modelAndView.addObject("info","类型转换异常");
    }
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
