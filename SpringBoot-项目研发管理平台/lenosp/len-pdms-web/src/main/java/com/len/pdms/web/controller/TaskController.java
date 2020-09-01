package com.len.pdms.web.controller;

import com.len.base.BaseController;
import com.len.pdms.model.vo.TaskVo;
import com.len.pdms.service.TaskService;
import com.len.util.JsonUtil;
import com.len.util.ReType;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 需求管理业务
 */
@Controller
@RequestMapping(value = "/pdms/task")
public class TaskController extends BaseController {

    @Reference
    private TaskService TaskService;

    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ReType selectList(TaskVo TaskVo,int page, int limit){
        ReType reType = TaskService.selectList(TaskVo,page,limit);
        return reType;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonUtil addProject(TaskVo TaskVo) {
        int status = TaskService.add(TaskVo);
        return JsonUtil.sucess("添加成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonUtil update(TaskVo TaskVo) {
        int status = TaskService.update(TaskVo);
        return JsonUtil.sucess("修改成功");
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public JsonUtil remove(TaskVo TaskVo) {
        int status = TaskService.remove(TaskVo);
        return JsonUtil.sucess("删除成功");
    }


}
