package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.entity.SysUser;
import com.len.exception.MyException;
import com.len.pdms.model.entity.Tenant;
import com.len.pdms.model.entity.TenantUser;
import com.len.pdms.model.vo.TenantVo;
import com.len.pdms.service.TenantService;
import com.len.pdms.service.provider.mapper.SysMapper;
import com.len.pdms.service.provider.mapper.TenantMapper;
import com.len.pdms.service.provider.mapper.TenantUserMapper;
import com.len.pdms.service.provider.session.SessionTemplate;
import com.len.util.BeanUtil;
import com.len.util.IDUtil;
import com.len.util.Md5Util;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;


/**
 * 租户管理
 */
@Service
public class TenantServiceImpl extends BaseServiceImpl<Tenant,String> implements TenantService {

    @Autowired
    private TenantMapper tenantMapper;

    @Autowired
    private TenantUserMapper tenantUserMapper;

    @Autowired
    private SysMapper sysMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    //@Autowired
    //private RestTemplate restTemplate;

    @Override
    public BaseMapper<Tenant, String> getMappser() {
        return tenantMapper;
    }

    @Override
    public int addTenant(TenantVo tenantVo) {

//        // 获取登录用户信息
//        System.err.println(sessionTemplate.getCurrentUser());
//        System.err.println(sessionTemplate.getTenantId());
//        System.err.println(sessionTemplate.getSessionId());

        // 添加租户
        Tenant tenant = new Tenant();
        BeanUtil.copyNotNullBean(tenantVo,tenant);
        tenant.setCreateDate(DateUtil.date());
        int status = this.insertSelective(tenant);

        // 添加一条用户信息
        Map map = Maps.newHashMap();
        map.put("id",tenant.getId());
        //map.put("tenant_id",tenant.getId());
        map.put("username",tenantVo.getUsername());
        map.put("password", Md5Util.getMD5(tenantVo.getPassword().trim(), tenantVo.getUsername().trim()));
        map.put("create_date", DateUtil.date());
        sysMapper.insertUser(map);

        // 租户用户信息
        TenantUser tenantUser = new TenantUser();
        tenantUser.setId(IDUtil.genId());
        tenantUser.setCreateDate(DateUtil.date());
        tenantUser.setTenantId(tenant.getId());
        tenantUser.setUserId(tenant.getId());
        tenantUser.setIsAdmin(1);
        tenantUserMapper.insert(tenantUser);

        // 默认用户租户角色设置
        Map ur = Maps.newHashMap();
        ur.put("user_id",tenant.getId());
        ur.put("role_id","f40b1dcd1f93462e94fe03aa15878b44"); // 默认租户角色ID
        sysMapper.insertUserRole(ur);


        /*String url="http://localhost:8081/";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id",id);
        HttpHeaders header = new HttpHeaders();
        // 需求需要传参为form-data格式
        header.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, header);
        JSONObject response = restTemplate.postForObject(url, httpEntity, JSONObject.class);*/

        return status;
    }

    @Override
    public int addTenantUser(String userName, String tenantId){
        String userId = sysMapper.getUserId(userName);
        if(StringUtils.isEmpty(userId)){
            return -1;
        }

        int count = tenantUserMapper.check(userId,tenantId);
        System.err.println("count:" + count);
        if(count > 0){
            return -2;
        }

        TenantUser tenantUser = new TenantUser();
        tenantUser.setId(IDUtil.genId());
        tenantUser.setCreateDate(DateUtil.date());
        tenantUser.setIsAdmin(0);
        tenantUser.setTenantId(tenantId);
        tenantUser.setUserId(userId); // TODO
        return tenantUserMapper.insert(tenantUser);
    }
}
