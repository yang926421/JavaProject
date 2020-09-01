package com.len.pdms.web.controller;

import com.len.base.BaseController;
import com.len.pdms.model.vo.OnlineVo;
import com.len.pdms.service.OnlineService;
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
@RequestMapping(value = "/pdms/online")
public class OnlineController extends BaseController {

    @Reference
    private OnlineService OnlineService;

    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ReType selectList(OnlineVo OnlineVo,int page, int limit){
        ReType reType = OnlineService.selectList(OnlineVo,page,limit);
        return reType;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonUtil addProject(OnlineVo OnlineVo) {
        int status = OnlineService.add(OnlineVo);
        return JsonUtil.sucess("添加成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonUtil update(OnlineVo OnlineVo) {
        int status = OnlineService.update(OnlineVo);
        return JsonUtil.sucess("修改成功");
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public JsonUtil remove(OnlineVo OnlineVo) {
        int status = OnlineService.remove(OnlineVo);
        return JsonUtil.sucess("删除成功");
    }


}
