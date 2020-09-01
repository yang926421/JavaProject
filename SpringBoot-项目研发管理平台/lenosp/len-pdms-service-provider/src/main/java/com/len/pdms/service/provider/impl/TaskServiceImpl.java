package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Task;
import com.len.pdms.model.vo.TaskVo;
import com.len.pdms.service.TaskService;
import com.len.pdms.service.provider.mapper.TaskMapper;
import com.len.pdms.service.provider.session.SessionTemplate;
import com.len.util.BeanUtil;
import com.len.util.ReType;
import org.apache.dubbo.config.annotation.Service;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 需求管理实现
 */
@Service
public class TaskServiceImpl extends BaseServiceImpl<Task,String> implements TaskService {

    @Autowired
    private TaskMapper TaskMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    @Override
    public BaseMapper<Task, String> getMappser() {
        return TaskMapper;
    }

    @Override
    public int add(TaskVo TaskVo) {
        Task Task = new Task();
        Task.setProjectId(sessionTemplate.getProjectId());
        Task.setTenantId(sessionTemplate.getTenantId());
        Task.setCreateDate(DateUtil.date());
        Task.setCreateUserId(sessionTemplate.getCurrentUser().getId());
        Task.setStatus(0);
        // 值拷贝
        BeanUtil.copyNotNullBean(TaskVo,Task);
        return this.insertSelective(Task);
    }

    @Override
    public int update(TaskVo TaskVo) {
        Task Task = new Task();
        BeanUtil.copyNotNullBean(TaskVo,Task);
        if(Task.getStatus() > 0){
            Task.setFinishDate(DateUtil.date());
        }
        return TaskMapper.updateByPrimaryKeySelective(Task);
    }

    @Override
    public int remove(TaskVo TaskVo) {
        return TaskMapper.deleteByPrimaryKey(TaskVo.getId());
    }

    @Override
    public ReType selectList(TaskVo TaskVo,int page ,int limit) {
        Page<?> tPage = PageHelper.startPage(page,limit);
        TaskVo.setProjectId(sessionTemplate.getProjectId());
        TaskVo.setTenantId(sessionTemplate.getTenantId());
        List<TaskVo> list = TaskMapper.selectList(TaskVo);
        List<TaskVo> voList = Lists.newArrayList();
        for (TaskVo Task: list) {
            TaskVo vo = new TaskVo();
            BeanUtil.copyNotNullBean(Task,vo);
            vo.setCreateDateText(DateUtil.formatDateTime(vo.getCreateDate()));
            vo.setFinishDateText(DateUtil.formatDateTime(vo.getFinishDate()));
            voList.add(vo);
        }
        return new ReType(tPage.getTotal(),voList);
    }

}
