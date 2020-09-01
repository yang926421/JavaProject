package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Requirement;
import com.len.pdms.model.entity.Risk;
import com.len.pdms.model.vo.RequirementVo;
import com.len.pdms.model.vo.RiskVo;

import java.util.List;

public interface RiskMapper extends com.len.base.BaseMapper<Risk,String> {

    // SysUser login(@Param("username") String username);

    List<RiskVo> selectList(RiskVo riskVo);


}