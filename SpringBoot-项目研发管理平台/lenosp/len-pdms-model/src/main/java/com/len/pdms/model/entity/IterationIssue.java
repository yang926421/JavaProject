package com.len.pdms.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 迭代问题
 */
@Table(name = "pdms_iteration_issue")
@Data
@ToString
@EqualsAndHashCode
public class IterationIssue {

    // 项目ID
    @Column(name = "issue_id")
    private String issueId;

    // 租户ID
    @Column(name = "iteration_id")
    private String iterationId;

    // ID
    @Id
    @Column
    private String id;

    // 状态 0-需求 1-缺陷 2-任务
    @Column(name = "issue_type")
    private int issueType;

}
