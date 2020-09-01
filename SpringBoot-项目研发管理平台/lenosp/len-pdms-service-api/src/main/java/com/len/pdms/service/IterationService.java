package com.len.pdms.service;

import com.len.base.BaseService;
import com.len.pdms.model.entity.Iteration;
import com.len.pdms.model.vo.IterationIssueVo;
import com.len.pdms.model.vo.IterationVo;
import com.len.util.ReType;

import java.util.List;

/**
 * 项目管理服务接口
 */
public interface IterationService extends BaseService<Iteration,String> {

    int add(IterationVo IterationVo);

    int update(IterationVo IterationVo);

    int remove(IterationVo IterationVo);

    ReType selectList(IterationVo IterationVo, int page, int limit);

    int addIssue(String id,String type,String json);

    int removeIssue(String id);

    ReType selectIssueList(IterationIssueVo iterationIssueVo, int page, int limit);
}
