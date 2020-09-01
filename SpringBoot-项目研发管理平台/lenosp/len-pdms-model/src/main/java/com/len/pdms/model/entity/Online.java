package com.len.pdms.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 需求实体
 */
@Table(name = "pdms_project_online")
@Data
@ToString
@EqualsAndHashCode
public class Online {

    // 项目ID
    @Column(name = "project_id")
    private String projectId;

    // 租户ID
    @Column(name = "tenant_id")
    private String tenantId;

    // ID
    @Id
    @Column
    private String id;

    // 发布版本
    @Column(name = "version_id")
    private String versionId;

    // 迭代
    @Column(name = "iteration_id")
    private String iterationId;

    // 名称
    @Column(name = "name")
    private String name;

    // 内容
    @Column(name = "content")
    private String content;

    // 创建时间
    @Column(name = "create_date")
    private Date createDate;

}
