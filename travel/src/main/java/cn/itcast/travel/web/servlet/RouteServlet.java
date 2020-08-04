package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service = new RouteServiceImpl();
    protected void pageQuery(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        //要去查询的哪一个目录下的内容
        String cidStr = request.getParameter("cid");
        //处理这些参数
        int cid = 0;
        if(cidStr != null && cidStr.length() > 0){
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;
        if(currentPageStr != null && currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }
        //第一次访问没有值定currentPage
        else{
            currentPage = 1;
        }
        //每页显示条数，如果不指定，则默认为5条
        int pageSize = 0;
        if(pageSizeStr != null && pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        //第一次访问没有值定currentPage
        else{
            pageSize = 5;
        }
        //调用servlet来查询出PageBean对象
        PageBean<Route> pb = service.pageQuery(cid, currentPage, pageSize);
        //序列化这个数据
        writeValue(pb, response);
    }


}
