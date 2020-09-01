package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Iteration;
import com.len.pdms.model.entity.IterationIssue;
import com.len.pdms.model.vo.IterationIssueVo;
import com.len.pdms.model.vo.IterationVo;

import java.util.List;

public interface IterationIssueMapper extends com.len.base.BaseMapper<IterationIssue,String> {

    List<IterationIssueVo> selectList(IterationIssueVo iterationIssueVo);


}