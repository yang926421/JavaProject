package com.len.pdms.web.controller;

import com.len.base.BaseController;
import com.len.pdms.model.vo.BugVo;
import com.len.pdms.service.BugService;
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
@RequestMapping(value = "/pdms/bug")
public class BugController extends BaseController {

    @Reference
    private BugService BugService;

    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ReType selectList(BugVo BugVo,int page, int limit){
        ReType reType = BugService.selectList(BugVo,page,limit);
        return reType;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonUtil addProject(BugVo BugVo) {
        int status = BugService.add(BugVo);
        return JsonUtil.sucess("添加成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonUtil update(BugVo BugVo) {
        int status = BugService.update(BugVo);
        return JsonUtil.sucess("修改成功");
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public JsonUtil remove(BugVo BugVo) {
        int status = BugService.remove(BugVo);
        return JsonUtil.sucess("删除成功");
    }


}
