package com.len.pdms.model.vo;

import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目Vo
 */
@Data
public class ProjectVo implements Serializable {

    private String tenantId;

    private String id;

    private String projectName;

    private Date createDate;

    private String icon;

}
