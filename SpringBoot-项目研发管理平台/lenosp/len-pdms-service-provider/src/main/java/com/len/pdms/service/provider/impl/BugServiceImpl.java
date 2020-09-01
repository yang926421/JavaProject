package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Bug;
import com.len.pdms.model.vo.BugVo;
import com.len.pdms.service.BugService;
import com.len.pdms.service.provider.mapper.BugMapper;
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
public class BugServiceImpl extends BaseServiceImpl<Bug,String> implements BugService {

    @Autowired
    private BugMapper BugMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    @Override
    public BaseMapper<Bug, String> getMappser() {
        return BugMapper;
    }

    @Override
    public int add(BugVo BugVo) {
        Bug Bug = new Bug();
        Bug.setProjectId(sessionTemplate.getProjectId());
        Bug.setTenantId(sessionTemplate.getTenantId());
        Bug.setCreateDate(DateUtil.date());
        Bug.setCreateUserId(sessionTemplate.getCurrentUser().getId());
        Bug.setStatus(0);
        // 值拷贝
        BeanUtil.copyNotNullBean(BugVo,Bug);
        return this.insertSelective(Bug);
    }

    @Override
    public int update(BugVo BugVo) {
        Bug Bug = new Bug();
        BeanUtil.copyNotNullBean(BugVo,Bug);
        if(Bug.getStatus() > 0){
            Bug.setFinishDate(DateUtil.date());
        }
        return BugMapper.updateByPrimaryKeySelective(Bug);
    }

    @Override
    public int remove(BugVo BugVo) {
        return BugMapper.deleteByPrimaryKey(BugVo.getId());
    }

    @Override
    public ReType selectList(BugVo BugVo,int page ,int limit) {
        Page<?> tPage = PageHelper.startPage(page,limit);
        BugVo.setProjectId(sessionTemplate.getProjectId());
        BugVo.setTenantId(sessionTemplate.getTenantId());
        List<BugVo> list = BugMapper.selectList(BugVo);
        List<BugVo> voList = Lists.newArrayList();
        for (BugVo Bug: list) {
            BugVo vo = new BugVo();
            BeanUtil.copyNotNullBean(Bug,vo);
            vo.setCreateDateText(DateUtil.formatDateTime(vo.getCreateDate()));
            vo.setFinishDateText(DateUtil.formatDateTime(vo.getFinishDate()));
            voList.add(vo);
        }
        return new ReType(tPage.getTotal(),voList);
    }

}
