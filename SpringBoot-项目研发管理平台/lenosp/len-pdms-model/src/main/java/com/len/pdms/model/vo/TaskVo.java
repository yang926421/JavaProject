package com.len.pdms.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 需求实体
 */
@Data
public class TaskVo implements Serializable {

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

    // 创建人
    private String createUserId;

    // 创建人
    private String createUserName;

    // 创建时间
    private Date finishDate;

    // 创建时间
    private String finishDateText;

    // 创建人
    private String dealUserId;

    // 创建人
    private String dealUserName;

    // 状态 0-新建 1-处理中 2-已完成
    private int status;

    // 状态 0-新建 1-处理中 2-已完成
    private String statusText;

    public String getStatusText() {
        if(status == 0) return "新建";
        if(status == 1) return "处理中";
        if(status == 2) return "已完成";
        return statusText;
    }

}
