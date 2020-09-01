package com.len.pdms.web.controller;

import com.alibaba.fastjson.JSON;
import com.len.base.BaseController;
import com.len.pdms.model.entity.TenantUser;
import com.len.pdms.model.vo.ProjectVo;
import com.len.pdms.model.vo.TenantVo;
import com.len.pdms.service.ProjectService;
import com.len.pdms.service.TenantService;
import com.len.util.JsonUtil;
import com.len.util.ReType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目管理业务
 */
@Controller
@RequestMapping(value = "/pdms/tenant")
@Api(value = "租户管理")
public class TenantController extends BaseController {

    @Reference
    //@Autowired
    private TenantService tenantService;

    @GetMapping(value = "/register")
    public String register(Model model) {
        return "/tenant-register";
    }

    @RequestMapping(value = "/addTenant")
    public String addTenant(TenantVo tenantVo,Model model) {
        System.err.println(JSON.toJSONString(tenantVo));
        int status = tenantService.addTenant(tenantVo);
        model.addAttribute("username",tenantVo.getUsername());
        return "/tenant-register-success";
    }

    @RequestMapping(value = "/invite")
    public String invite(Model model,String tenantId) {
        model.addAttribute("tenantId",tenantId);
        return "/tenant-adduser";
    }

    @RequestMapping(value = "/addTenantUser")
    @ResponseBody
    public JsonUtil addTenantUser(String userName, String tenantId) {
        int result = tenantService.addTenantUser(userName, tenantId);
        if (result == -1) {
            return JsonUtil.error("邀请用户不存在");
        }else if (result == -2){
            return JsonUtil.error("邀请用户已加入，不能重复邀请");
        }else{
            return JsonUtil.sucess("邀请成功");
        }
    }

}
