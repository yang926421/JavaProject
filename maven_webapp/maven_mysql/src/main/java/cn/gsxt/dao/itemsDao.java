package cn.gsxt.dao;

import cn.gsxt.damain.items;

import java.util.List;

public interface itemsDao  {
    public List<items> findAll() throws Exception;
}
