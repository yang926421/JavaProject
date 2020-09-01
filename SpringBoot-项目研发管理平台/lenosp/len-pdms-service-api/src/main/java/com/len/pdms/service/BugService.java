package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Bug;
import com.len.pdms.model.vo.BugVo;
import com.len.util.ReType;

/**
 * 项目管理服务接口
 */
public interface BugService extends BaseService<Bug,String> {

    int add(BugVo BugVo);

    int update(BugVo BugVo);

    int remove(BugVo BugVo);

    ReType selectList(BugVo BugVo, int page, int limit);
}
