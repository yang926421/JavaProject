package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Iteration;
import com.len.pdms.model.vo.IterationVo;

import java.util.List;

public interface IterationMapper extends com.len.base.BaseMapper<Iteration,String> {

    List<Iteration> selectList(IterationVo IterationVo);


}