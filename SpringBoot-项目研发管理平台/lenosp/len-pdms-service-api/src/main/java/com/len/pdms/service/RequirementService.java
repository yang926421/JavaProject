package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Project;
import com.len.pdms.model.entity.Requirement;
import com.len.pdms.model.vo.ProjectVo;
import com.len.pdms.model.vo.RequirementVo;
import com.len.util.ReType;

import java.util.List;

/**
 * 项目管理服务接口
 */
public interface RequirementService extends BaseService<Requirement,String> {

    int add(RequirementVo requirementVo);

    int update(RequirementVo requirementVo);

    int remove(RequirementVo requirementVo);

    ReType selectList(RequirementVo requirementVo,int page ,int limit);
}
