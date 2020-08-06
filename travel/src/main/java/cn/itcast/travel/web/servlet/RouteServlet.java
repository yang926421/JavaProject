package cn.itcast.travel.web.servlet;

import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
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
    private FavoriteService favoriteService = new FavoriteServiceImpl();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        //要去查询的哪一个目录下的内容
        String cidStr = request.getParameter("cid");

        //接收rname搜索框填写的内容
        String rname = request.getParameter("rname");
        System.out.println("-----1--");
        System.out.println(rname);
        //rname传递过来是乱码
        System.out.println("-----2-----");
        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        if(rname.length()<=0){ //如果rname为空字符串"" 让其为null
            rname = null;
        }
        //处理这些参数
        int cid = 0;
        //字符串的null判断是因为传的时候首页地方的cid传的是null
        if(cidStr != null && cidStr.length() > 0 &&!"null".equalsIgnoreCase(cidStr)){
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
        System.out.println("要去service查询数据了");
        PageBean<Route> pb = service.pageQuery(cid, currentPage, pageSize, rname);
        //序列化这个数据
        writeValue(pb, response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //根据id查询一个旅游线路的详细信息
        //接收id
        String rid = request.getParameter("rid");
        //
        Route route =  service.findOne(rid);
        //返回到客户端
        writeValue(route, response);
    }

    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取线路id
        String rid = request.getParameter("rid");
        //获取当前用户登录的user
        User user =  (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null){
            //用户尚未登录
            return;
        }
        else{
            //用户已经登录
            uid = user.getUid();
        }
    //调用favoriteService查询
        //3. 调用FavoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);

        //4. 写回客户端
        writeValue(flag,response);

    }

    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取线路rid
        String rid = request.getParameter("rid");
        //2. 获取当前登录的用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if(user == null){
            //用户尚未登录
            return ;
        }else{
            //用户已经登录
            uid = user.getUid();
        }


        //3. 调用service添加
        favoriteService.add(rid,uid);

    }
    }
