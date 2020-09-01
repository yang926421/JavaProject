package com.len.pdms.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 需求实体
 */
@Data
public class VersionVo implements Serializable {

    // 项目ID
    private String projectId;

    // 租户ID
    private String tenantId;

    // ID
    private String id;

    // 名称
    private String name;

    // 内容
    private String content;

    // 创建时间
    private Date createDate;

    // 创建时间
    private String createDateText;

}
