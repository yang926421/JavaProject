package cn.gsxt.service;

import cn.gsxt.domain.Province;

import java.util.List;

public interface provinceService {
    public List<Province> findAll();

    public String findAllJson();
}
