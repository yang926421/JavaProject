package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Risk;
import com.len.pdms.model.vo.RiskVo;
import com.len.pdms.service.RiskService;
import com.len.pdms.service.provider.mapper.RiskMapper;
import com.len.pdms.service.provider.session.SessionTemplate;
import com.len.util.BeanUtil;
import com.len.util.ReType;
import org.apache.dubbo.config.annotation.Service;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 需求管理实现
 */
@Service
public class RiskServiceImpl extends BaseServiceImpl<Risk,String> implements RiskService {

    @Autowired
    private RiskMapper RiskMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    @Override
    public BaseMapper<Risk, String> getMappser() {
        return RiskMapper;
    }

    @Override
    public int add(RiskVo RiskVo) {
        Risk Risk = new Risk();
        Risk.setProjectId(sessionTemplate.getProjectId());
        Risk.setTenantId(sessionTemplate.getTenantId());
        Risk.setCreateDate(DateUtil.date());
        Risk.setCreateUserId(sessionTemplate.getCurrentUser().getId());
        Risk.setStatus(0);
        // 值拷贝
        BeanUtil.copyNotNullBean(RiskVo,Risk);
        return this.insertSelective(Risk);
    }

    @Override
    public int update(RiskVo RiskVo) {
        Risk Risk = new Risk();
        BeanUtil.copyNotNullBean(RiskVo,Risk);
        if(Risk.getStatus() > 0){
            Risk.setFinishDate(DateUtil.date());
        }
        return RiskMapper.updateByPrimaryKeySelective(Risk);
    }

    @Override
    public int remove(RiskVo RiskVo) {
        return RiskMapper.deleteByPrimaryKey(RiskVo.getId());
    }

    @Override
    public ReType selectList(RiskVo RiskVo,int page ,int limit) {
        Page<?> tPage = PageHelper.startPage(page,limit);
        RiskVo.setProjectId(sessionTemplate.getProjectId());
        RiskVo.setTenantId(sessionTemplate.getTenantId());
        List<RiskVo> list = RiskMapper.selectList(RiskVo);
        List<RiskVo> voList = Lists.newArrayList();
        for (RiskVo Risk: list) {
            RiskVo vo = new RiskVo();
            BeanUtil.copyNotNullBean(Risk,vo);
            vo.setCreateDateText(DateUtil.formatDateTime(vo.getCreateDate()));
            vo.setFinishDateText(DateUtil.formatDateTime(vo.getFinishDate()));
            voList.add(vo);
        }
        return new ReType(tPage.getTotal(),voList);
    }

}
