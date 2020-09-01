package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Tenant;
import com.len.pdms.model.entity.TenantUser;
import org.apache.ibatis.annotations.Param;

public interface TenantUserMapper extends com.len.base.BaseMapper<TenantUser,String> {


    // SysUser login(@Param("username") String username);

    int check(@Param("userId") String userId, @Param("tenantId")  String tenantId);
}