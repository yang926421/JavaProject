package com.len.pdms.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 租户用户实体
 */
@Table(name = "pdms_tenant_user")
@Data
@ToString
@EqualsAndHashCode
public class TenantUser {

    // ID
    @Id
    @Column
    private String id;

    // 租户ID
    @Column(name = "tenant_id")
    private String tenantId;

    // 用户ID
    @Column(name = "user_id")
    private String userId;

    // 是否管理员
    @Column(name = "is_admin")
    private int isAdmin;

    // 创建时间
    @Column(name = "create_date")
    private Date createDate;

}
