package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Project;
import com.len.pdms.model.vo.ProjectVo;
import com.len.pdms.service.ProjectService;
import com.len.pdms.service.provider.mapper.ProjectMapper;
import com.len.pdms.service.provider.session.SessionTemplate;
import com.len.util.BeanUtil;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;


/**
 * 项目管理实现
 */
@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project,String> implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
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
    }
}
