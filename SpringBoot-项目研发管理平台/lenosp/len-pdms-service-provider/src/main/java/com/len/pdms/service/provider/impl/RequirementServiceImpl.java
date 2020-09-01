package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Project;
import com.len.pdms.model.entity.Requirement;
import com.len.pdms.model.vo.ProjectVo;
import com.len.pdms.model.vo.RequirementVo;
import com.len.pdms.service.ProjectService;
import com.len.pdms.service.RequirementService;
import com.len.pdms.service.provider.mapper.ProjectMapper;
import com.len.pdms.service.provider.mapper.RequirementMapper;
import com.len.pdms.service.provider.session.SessionTemplate;
import com.len.util.BeanUtil;
import com.len.util.ReType;
import org.apache.dubbo.config.annotation.Service;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


/**
 * 需求管理实现
 */
@Service
public class RequirementServiceImpl extends BaseServiceImpl<Requirement,String> implements RequirementService {

    @Autowired
    private RequirementMapper requirementMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    @Override
    public BaseMapper<Requirement, String> getMappser() {
        return requirementMapper;
    }

    @Override
    public int add(RequirementVo requirementVo) {
        Requirement requirement = new Requirement();
        requirement.setProjectId(sessionTemplate.getProjectId());
        requirement.setTenantId(sessionTemplate.getTenantId());
        requirement.setCreateDate(DateUtil.date());
        requirement.setCreateUserId(sessionTemplate.getCurrentUser().getId());
        requirement.setStatus(0);
        // 值拷贝
        BeanUtil.copyNotNullBean(requirementVo,requirement);
        return this.insertSelective(requirement);
    }

    @Override
    public int update(RequirementVo requirementVo) {
        Requirement requirement = new Requirement();
        BeanUtil.copyNotNullBean(requirementVo,requirement);
        if(requirement.getStatus() > 0){
            requirement.setFinishDate(DateUtil.date());
        }
        return requirementMapper.updateByPrimaryKeySelective(requirement);
    }

    @Override
    public int remove(RequirementVo requirementVo) {
        return requirementMapper.deleteByPrimaryKey(requirementVo.getId());
    }

    @Override
    public ReType selectList(RequirementVo requirementVo,int page ,int limit) {
        Page<?> tPage = PageHelper.startPage(page,limit);
        requirementVo.setProjectId(sessionTemplate.getProjectId());
        requirementVo.setTenantId(sessionTemplate.getTenantId());
        List<RequirementVo> list = requirementMapper.selectList(requirementVo);
        List<RequirementVo> voList = Lists.newArrayList();
        for (RequirementVo requirement: list) {
            RequirementVo vo = new RequirementVo();
            BeanUtil.copyNotNullBean(requirement,vo);
            vo.setCreateDateText(DateUtil.formatDateTime(vo.getCreateDate()));
            vo.setFinishDateText(DateUtil.formatDateTime(vo.getFinishDate()));
            voList.add(vo);
        }
        return new ReType(tPage.getTotal(),voList);
    }

    /* @Override
    public BaseMapper<Project, String> getMappser() {
        return projectMapper;
    }

    @Override
    public int addProject(ProjectVo projectVo) {
        Project project = new Project();
        project.setCreateDate(DateUtil.date());
        project.setCreateUserId(sessionTemplate.getCurrentUser().getId());
        BeanUtil.copyNotNullBean(projectVo,project);
        return this.insertSelective(project);
    }

    @Override
    public int removeProject(ProjectVo projectVo) {
        return this.deleteByPrimaryKey(projectVo.getId());
    }*/
}
