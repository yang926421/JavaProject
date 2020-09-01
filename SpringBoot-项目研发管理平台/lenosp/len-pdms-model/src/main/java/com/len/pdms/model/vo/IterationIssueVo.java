package com.len.pdms.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 需求实体
 */
@Data
public class IterationIssueVo implements Serializable {

    private String issueId;

    private String iterationId;

    // ID
    private String id;

    // 状态 0-新建 1-处理中 2-已完成
    private int issueType;

    // 状态 0-新建 1-处理中 2-已完成
    private String issueTypeText;

    private String name;
    private String content;

    private Date createDate;
    private String createDateText;

    private int status;
    private String statusText;

    public String getIssueTypeText() {
        if(issueType == 0) return "需求";
        if(issueType == 1) return "缺陷";
        if(issueType == 2) return "任务";
        return issueTypeText;
    }

    public String getStatusText() {
        if(status == 0) return "新建";
        if(status == 1) return "处理中";
        if(status == 2) return "已完成";
        return issueTypeText;
    }

}
