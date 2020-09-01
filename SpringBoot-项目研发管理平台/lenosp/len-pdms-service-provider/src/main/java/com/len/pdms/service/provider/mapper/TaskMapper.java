package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Task;
import com.len.pdms.model.vo.TaskVo;

import java.util.List;

public interface TaskMapper extends com.len.base.BaseMapper<Task,String> {

    // SysUser login(@Param("username") String username);

    List<TaskVo> selectList(TaskVo TaskVo);


}