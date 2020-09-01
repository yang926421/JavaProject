package com.len.pdms.web.controller;

import com.len.base.BaseController;
import com.len.pdms.model.vo.IterationIssueVo;
import com.len.pdms.model.vo.IterationVo;
import com.len.pdms.service.IterationService;
import com.len.util.JsonUtil;
import com.len.util.ReType;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 迭代管理业务
 */
@Controller
@RequestMapping(value = "/pdms/iteration")
public class IterationController extends BaseController {

    @Reference
    private IterationService IterationService;

    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ReType selectList(IterationVo IterationVo,int page, int limit){
        ReType reType = IterationService.selectList(IterationVo,page,limit);
        return reType;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonUtil addProject(IterationVo IterationVo) {
        int status = IterationService.add(IterationVo);
        return JsonUtil.sucess("添加成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonUtil update(IterationVo IterationVo) {
        int status = IterationService.update(IterationVo);
        return JsonUtil.sucess("修改成功");
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public JsonUtil remove(IterationVo IterationVo) {
        int status = IterationService.remove(IterationVo);
        return JsonUtil.sucess("删除成功");
    }

    @RequestMapping(value = "/selectIssueList")
    @ResponseBody
    public ReType selectIssueList(IterationIssueVo iterationIssueVo, int page, int limit) {
        return IterationService.selectIssueList(iterationIssueVo,page,limit);
    }

    @RequestMapping(value = "/addIssue")
    @ResponseBody
    public JsonUtil addIssue(String id,String type,String items) {
        int status = IterationService.addIssue(id,type,items);
        return JsonUtil.sucess("添加成功");
    }

    @RequestMapping(value = "/removeIssue")
    @ResponseBody
    public JsonUtil removeIssue(String id) {
        int status = IterationService.removeIssue(id);
        return JsonUtil.sucess("删除成功");
    }
}
