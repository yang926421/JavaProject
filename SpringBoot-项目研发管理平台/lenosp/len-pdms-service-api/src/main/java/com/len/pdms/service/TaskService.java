package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Risk;
import com.len.pdms.model.entity.Task;
import com.len.pdms.model.vo.TaskVo;
import com.len.util.ReType;

/**
 * 项目管理服务接口
 */
public interface TaskService extends BaseService<Task,String> {

    int add(TaskVo TaskVo);

    int update(TaskVo TaskVo);

    int remove(TaskVo TaskVo);

    ReType selectList(TaskVo TaskVo, int page, int limit);
}
