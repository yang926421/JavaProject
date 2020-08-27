package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao dao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        System.out.println("routeServiceImpl查");
        //封装pageBean
        PageBean<Route> pageBean = new PageBean<>();
//        System.out.println(cid);
//        System.out.println(currentPage);
//        System.out.println(pageSize);
//        System.out.println(rname);
        //设置当前页码
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        int totalCount = 0;
        totalCount = dao.findTotalCount(cid, rname);
        System.out.println(totalCount);
        pageBean.setTotalCount(totalCount);
        int start = 0;
        start = currentPage > 1 ? (currentPage - 1) * pageSize : 0;
        List<Route> list = dao.findByPage(cid, start, pageSize, rname);
        System.out.println(list);
        pageBean.setList(list);
        //设置总页数
        int totalPage = 0;
        totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public Route findOne(String rid) {
        //调用rid去dao层查询,返回一个route对象
        System.out.println("去dao层查询");
        Route route = dao.findOne(Integer.parseInt(rid));
        //根据routeid去查询图片的集合
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        route.setRouteImgList(routeImgList);
        //根据route的sid(商家的id)去查询卖家的id
        Seller seller = sellerDao.findById(route.getRid());
        route.setSeller(seller);
        //4. 查询收藏次数
        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);
        return route;
    }
}
