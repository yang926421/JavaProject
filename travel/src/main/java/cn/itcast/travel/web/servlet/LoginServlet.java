package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("跳转登陆servlet");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用service查询
        UserService service = new UserServiceImpl();
        User u =  service.login(user);
        System.out.println(u.getName());
        System.out.println(u==null);
        System.out.println(u.getStatus());
        ResultInfo info = new ResultInfo();
        //判断用户名或密码是否正确
        if(u==null){
            //用户名密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        //判断用户是否激活
        if(u!=null && !u.getStatus().equals("Y")){
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("尚未激活,请登录邮箱激活");

        }
        //登录成功的判断
        if(u!=null && "Y".equals(u.getStatus())){
            info.setFlag(true);
        }
        //响应数据给前端
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;character=utf-8");
        mapper.writeValue(response.getOutputStream(), info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
