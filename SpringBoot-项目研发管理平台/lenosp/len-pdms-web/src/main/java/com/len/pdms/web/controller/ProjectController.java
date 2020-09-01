package com.len.pdms.web.controller;

import com.len.base.BaseController;
import com.len.pdms.model.vo.ProjectVo;
import com.len.pdms.service.ProjectService;
import com.len.util.JsonUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目管理业务
 */
@Controller
@RequestMapping(value = "/pdms/project")
public class ProjectController extends BaseController {

    @Reference
    private ProjectService projectService;


    @RequestMapping(value = "/showProject")
    public String showProject(Model model,String tenantId){
        model.addAttribute("tenantId",tenantId);
        System.err.println(tenantId);
        return "pdms/project/add-project";
    }

    @RequestMapping(value = "/addProject")
    @ResponseBody
    public JsonUtil addProject(ProjectVo projectVo) {
        int status = projectService.addProject(projectVo);
        return JsonUtil.sucess("项目添加成功");
    }

    @RequestMapping(value = "/removeProject")
    @ResponseBody
    public JsonUtil removeProject(ProjectVo projectVo) {
        int status = projectService.removeProject(projectVo);
        return JsonUtil.sucess("项目删除成功");
    }

}
