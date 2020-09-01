package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Tenant;
import com.len.pdms.model.entity.TenantUser;
import com.len.pdms.model.vo.TenantVo;

/**
 * 租户管理服务接口
 */
public interface TenantService extends BaseService<Tenant,String> {

    int addTenant(TenantVo tenantVo);

    int addTenantUser(String userName,String tenantId);

}
