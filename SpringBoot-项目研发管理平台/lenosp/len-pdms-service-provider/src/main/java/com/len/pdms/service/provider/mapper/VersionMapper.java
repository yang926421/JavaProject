package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Requirement;
import com.len.pdms.model.entity.Version;
import com.len.pdms.model.vo.RequirementVo;
import com.len.pdms.model.vo.VersionVo;

import java.util.List;

public interface VersionMapper extends com.len.base.BaseMapper<Version,String> {

    List<Version> selectList(VersionVo versionVo);


}