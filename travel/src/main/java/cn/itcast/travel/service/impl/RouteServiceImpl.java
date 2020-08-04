package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteDao dao = new RouteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {
        //封装pageBean
        PageBean<Route> pageBean = new PageBean<>();
        //设置当前页码
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        int totalCount = 0;
        totalCount =  dao.findTotalCount(cid);
        pageBean.setTotalCount(totalCount);
        int start = 0;
        start = currentPage > 1 ? (currentPage - 1) * pageSize : 0;
        List<Route> list = dao.findByPage(cid, start, pageSize);
        pageBean.setList(list);
        //设置总页数
        int totalPage = 0;
        totalPage = totalCount % pageSize == 0 ? (totalCount/pageSize):(totalCount/pageSize)+1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
