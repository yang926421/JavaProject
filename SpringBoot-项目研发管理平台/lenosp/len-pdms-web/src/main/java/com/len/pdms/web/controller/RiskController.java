package com.len.pdms.web.controller;

import com.len.base.BaseController;
import com.len.pdms.model.vo.RiskVo;
import com.len.pdms.service.RiskService;
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
@RequestMapping(value = "/pdms/risk")
public class RiskController extends BaseController {

    @Reference
    private RiskService RiskService;

    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ReType selectList(RiskVo RiskVo,int page, int limit){
        ReType reType = RiskService.selectList(RiskVo,page,limit);
        return reType;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonUtil addProject(RiskVo RiskVo) {
        int status = RiskService.add(RiskVo);
        return JsonUtil.sucess("添加成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonUtil update(RiskVo RiskVo) {
        int status = RiskService.update(RiskVo);
        return JsonUtil.sucess("修改成功");
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public JsonUtil remove(RiskVo RiskVo) {
        int status = RiskService.remove(RiskVo);
        return JsonUtil.sucess("删除成功");
    }


}
