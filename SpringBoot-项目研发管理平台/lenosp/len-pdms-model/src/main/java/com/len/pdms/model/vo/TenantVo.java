package com.len.pdms.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 租户VO
 */
@Data
public class TenantVo implements Serializable {

    // ID
    private String id;

    // 项目名称
    private String tenantName;

    // 创建用户
    private String username;

    // 创建用户密码
    private String password;

    // 创建时间
    private Date createDate;

    private String sessionId;

}
