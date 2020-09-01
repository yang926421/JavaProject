package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Online;
import com.len.pdms.model.vo.OnlineVo;
import com.len.pdms.service.OnlineService;
import com.len.pdms.service.provider.mapper.OnlineMapper;
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
public class OnlineServiceImpl extends BaseServiceImpl<Online,String> implements OnlineService {

    @Autowired
    private OnlineMapper OnlineMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    @Override
    public BaseMapper<Online, String> getMappser() {
        return OnlineMapper;
    }

    @Override
    public int add(OnlineVo OnlineVo) {
        Online Online = new Online();
        Online.setProjectId(sessionTemplate.getProjectId());
        Online.setTenantId(sessionTemplate.getTenantId());
        Online.setCreateDate(DateUtil.date());
        // 值拷贝
        BeanUtil.copyNotNullBean(OnlineVo,Online);
        return this.insertSelective(Online);
    }

    @Override
    public int update(OnlineVo OnlineVo) {
        Online Online = new Online();
        BeanUtil.copyNotNullBean(OnlineVo,Online);
        return OnlineMapper.updateByPrimaryKeySelective(Online);
    }

    @Override
    public int remove(OnlineVo OnlineVo) {
        return OnlineMapper.deleteByPrimaryKey(OnlineVo.getId());
    }

    @Override
    public ReType selectList(OnlineVo OnlineVo,int page ,int limit) {
        OnlineVo.setProjectId(sessionTemplate.getProjectId());
        OnlineVo.setTenantId(sessionTemplate.getTenantId());
        List<OnlineVo> list = Lists.newArrayList();
        long total = 0;
        if(page > 0){
            Page<?> tPage = PageHelper.startPage(page,limit);
            list = OnlineMapper.selectList(OnlineVo);
            total = tPage.getTotal();
        }else{
            list = OnlineMapper.selectList(OnlineVo);
        }
        List<OnlineVo> voList = Lists.newArrayList();
        for (OnlineVo Online: list) {
            OnlineVo vo = new OnlineVo();
            BeanUtil.copyNotNullBean(Online,vo);
            vo.setCreateDateText(DateUtil.formatDateTime(vo.getCreateDate()));
            voList.add(vo);
        }
        return new ReType(total,voList);
    }

}
