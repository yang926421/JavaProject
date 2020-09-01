package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Project;
import com.len.pdms.model.vo.ProjectVo;

/**
 * 项目管理服务接口
 */
public interface ProjectService extends BaseService<Project,String> {

    int addProject(ProjectVo projectVo);

    int removeProject(ProjectVo projectVo);
}
