package com.len.pdms.web.controller;

import com.len.base.BaseController;
import com.len.pdms.model.vo.RequirementVo;
import com.len.pdms.model.vo.VersionVo;
import com.len.pdms.service.RequirementService;
import com.len.pdms.service.VersionService;
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
@RequestMapping(value = "/pdms/version")
public class VersionController extends BaseController {

    @Reference
    private VersionService versionService;

    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ReType selectList(VersionVo versionVo,int page, int limit){
        ReType reType = versionService.selectList(versionVo,page,limit);
        return reType;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonUtil addProject(VersionVo versionVo) {
        int status = versionService.add(versionVo);
        return JsonUtil.sucess("添加成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonUtil update(VersionVo versionVo) {
        int status = versionService.update(versionVo);
        return JsonUtil.sucess("修改成功");
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public JsonUtil remove(VersionVo versionVo) {
        int status = versionService.remove(versionVo);
        return JsonUtil.sucess("删除成功");
    }


}
