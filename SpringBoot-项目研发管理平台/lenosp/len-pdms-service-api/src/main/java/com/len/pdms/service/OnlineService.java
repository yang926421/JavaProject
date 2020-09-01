package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Online;
import com.len.pdms.model.vo.OnlineVo;
import com.len.util.ReType;

/**
 * 项目管理服务接口
 */
public interface OnlineService extends BaseService<Online,String> {

    int add(OnlineVo OnlineVo);

    int update(OnlineVo OnlineVo);

    int remove(OnlineVo OnlineVo);

    ReType selectList(OnlineVo OnlineVo, int page, int limit);
}
