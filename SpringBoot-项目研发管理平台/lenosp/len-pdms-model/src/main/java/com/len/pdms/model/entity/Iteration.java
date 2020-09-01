package com.len.pdms.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 迭代实体
 */
@Table(name = "pdms_iteration")
@Data
@ToString
@EqualsAndHashCode
public class Iteration {

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

    // 名称
    @Column(name = "name")
    private String name;

    // 迭代目标
    @Column(name = "content")
    private String content;

    // 创建时间
    @Column(name = "create_date")
    private Date createDate;

    // 开始时间
    @Column(name = "start_date")
    private Date startDate;

    // 结束时间
    @Column(name = "end_date")
    private Date endDate;

    // 状态 0-新建 1-处理中 2-已完成
    @Column
    private int status;

}
