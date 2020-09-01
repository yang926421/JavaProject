package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Project;

import java.util.Map;

public interface SysMapper {

    // SysUser login(@Param("username") String username);

    int insertUser(Map map);

    int insertUserRole(Map map);

    String getUserId(String username);

}