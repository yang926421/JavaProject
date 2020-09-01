package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Risk;
import com.len.pdms.model.vo.RiskVo;
import com.len.util.ReType;

/**
 * 项目管理服务接口
 */
public interface RiskService extends BaseService<Risk,String> {

    int add(RiskVo riskVo);

    int update(RiskVo riskVo);

    int remove(RiskVo riskVo);

    ReType selectList(RiskVo riskVo, int page, int limit);
}
