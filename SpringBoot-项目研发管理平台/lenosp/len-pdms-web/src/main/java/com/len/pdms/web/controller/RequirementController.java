package com.len.pdms.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.len.base.BaseController;
import com.len.pdms.model.vo.ProjectVo;
import com.len.pdms.model.vo.RequirementVo;
import com.len.pdms.service.ProjectService;
import com.len.pdms.service.RequirementService;
import com.len.util.JsonUtil;
import com.len.util.ReType;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 需求管理业务
 */
@Controller
@RequestMapping(value = "/pdms/requirement")
public class RequirementController extends BaseController {

    @Reference
    private RequirementService requirementService;

    /*@RequestMapping(value = "/show")
    public String show(Model model,String tenantId){
        return "pdms/requirement/requirementList";
    }

    @RequestMapping(value = "/showAdd")
    public String showAdd(Model model,String tenantId){
        return "pdms/requirement/requirementList";
    }

    @RequestMapping(value = "/showUpdate")
    public String showUpdate(Model model,String tenantId){
        return "pdms/requirement/requirementList";
    }*/

    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ReType selectList(RequirementVo requirementVo,int page, int limit){
        ReType reType = requirementService.selectList(requirementVo,page,limit);
        return reType;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonUtil addProject(RequirementVo requirementVo) {
        int status = requirementService.add(requirementVo);
        return JsonUtil.sucess("添加成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonUtil update(RequirementVo requirementVo) {
        int status = requirementService.update(requirementVo);
        return JsonUtil.sucess("修改成功");
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public JsonUtil remove(RequirementVo requirementVo) {
        int status = requirementService.remove(requirementVo);
        return JsonUtil.sucess("删除成功");
    }


}
