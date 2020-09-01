package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Requirement;
import com.len.pdms.model.entity.Version;
import com.len.pdms.model.vo.RequirementVo;
import com.len.pdms.model.vo.VersionVo;
import com.len.pdms.service.RequirementService;
import com.len.pdms.service.VersionService;
import com.len.pdms.service.provider.mapper.RequirementMapper;
import com.len.pdms.service.provider.mapper.VersionMapper;
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
public class VersionServiceImpl extends BaseServiceImpl<Version,String> implements VersionService {

    @Autowired
    private VersionMapper versionMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    @Override
    public BaseMapper<Version, String> getMappser() {
        return versionMapper;
    }

    @Override
    public int add(VersionVo versionVo) {
        Version version = new Version();
        version.setProjectId(sessionTemplate.getProjectId());
        version.setTenantId(sessionTemplate.getTenantId());
        version.setCreateDate(DateUtil.date());
        // 值拷贝
        BeanUtil.copyNotNullBean(versionVo,version);
        return this.insertSelective(version);
    }

    @Override
    public int update(VersionVo versionVo) {
        Version version = new Version();
        BeanUtil.copyNotNullBean(versionVo,version);
        return versionMapper.updateByPrimaryKeySelective(version);
    }

    @Override
    public int remove(VersionVo versionVo) {
        return versionMapper.deleteByPrimaryKey(versionVo.getId());
    }

    @Override
    public ReType selectList(VersionVo versionVo,int page ,int limit) {
        versionVo.setProjectId(sessionTemplate.getProjectId());
        versionVo.setTenantId(sessionTemplate.getTenantId());
        List<Version> list = Lists.newArrayList();
        long total = 0;
        if(page > 0){
            Page<?> tPage = PageHelper.startPage(page,limit);
            list = versionMapper.selectList(versionVo);
            total = tPage.getTotal();
        }else{
            list = versionMapper.selectList(versionVo);
        }
        List<VersionVo> voList = Lists.newArrayList();
        for (Version version: list) {
            VersionVo vo = new VersionVo();
            BeanUtil.copyNotNullBean(version,vo);
            vo.setCreateDateText(DateUtil.formatDateTime(vo.getCreateDate()));
            voList.add(vo);
        }
        return new ReType(total,voList);
    }

}
