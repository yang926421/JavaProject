package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Requirement;
import com.len.pdms.model.vo.RequirementVo;

import java.util.List;

public interface RequirementMapper extends com.len.base.BaseMapper<Requirement,String> {

    // SysUser login(@Param("username") String username);

    List<RequirementVo> selectList(RequirementVo requirementVo);


}