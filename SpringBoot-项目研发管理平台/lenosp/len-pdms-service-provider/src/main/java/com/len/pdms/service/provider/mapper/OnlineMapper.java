package com.len.pdms.service.provider.mapper;

import com.len.pdms.model.entity.Online;
import com.len.pdms.model.vo.OnlineVo;

import java.util.List;

public interface OnlineMapper extends com.len.base.BaseMapper<Online,String> {

    List<OnlineVo> selectList(OnlineVo OnlineVo);


}