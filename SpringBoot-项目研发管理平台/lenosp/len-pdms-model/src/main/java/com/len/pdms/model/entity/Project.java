package com.len.pdms.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 项目实体
 */
@Table(name = "pdms_project")
@Data
@ToString
@EqualsAndHashCode
public class Project {

    // 租户ID
    @Column(name = "tenant_id")
    private String tenantId;

    // ID
    @Id
    @Column
    private String id;

    // 项目名称
    @Column(name = "project_name")
    private String projectName;

    // 创建时间
    @Column(name = "create_date")
    private Date createDate;

    // 创建人
    @Column(name = "create_user_id")
    private String createUserId;

    // 项目图标
    @Column
    private String icon;

}
