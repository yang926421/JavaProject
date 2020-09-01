package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Requirement;
import com.len.pdms.model.entity.Version;
import com.len.pdms.model.vo.RequirementVo;
import com.len.pdms.model.vo.VersionVo;
import com.len.util.ReType;

/**
 * 项目管理服务接口
 */
public interface VersionService extends BaseService<Version,String> {

    int add(VersionVo versionVo);

    int update(VersionVo versionVo);

    int remove(VersionVo versionVo);

    ReType selectList(VersionVo versionVo, int page, int limit);
}
