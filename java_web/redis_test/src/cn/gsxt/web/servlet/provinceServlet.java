package cn.gsxt.web.servlet;

import cn.gsxt.domain.Province;
import cn.gsxt.service.impl.provinceServiceImpl;
import cn.gsxt.service.provinceService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class provinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 点击请选择省份，前台发送ajax请求，发送json数据给前台
        provinceService service =  new provinceServiceImpl();
//        List<Province> list = service.findAll();
//        //获取到list数据将其转换成json字符串
//        ObjectMapper mapper = new ObjectMapper();
//        //转换成json字符串
//        String json = mapper.writeValueAsString(list);
        //发送
        //使用redis数据库查询
        System.out.println(1234);
        String json = service.findAllJson();
        System.out.println(2345);
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
