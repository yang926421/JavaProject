package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Bug;
import com.len.pdms.model.vo.BugVo;

import java.util.List;

public interface BugMapper extends com.len.base.BaseMapper<Bug,String> {

    // SysUser login(@Param("username") String username);

    List<BugVo> selectList(BugVo BugVo);


}