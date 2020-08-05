package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {
    //根据线路的id去另一张表查询图片的集合
    public List<RouteImg> findByRid(int rid);
}
