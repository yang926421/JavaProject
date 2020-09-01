package com.len.pdms.service.provider.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.len.base.BaseMapper;
import com.len.base.impl.BaseServiceImpl;
import com.len.pdms.model.entity.Iteration;
import com.len.pdms.model.entity.IterationIssue;
import com.len.pdms.model.vo.IterationIssueVo;
import com.len.pdms.model.vo.IterationVo;
import com.len.pdms.service.IterationService;
import com.len.pdms.service.provider.mapper.IterationIssueMapper;
import com.len.pdms.service.provider.mapper.IterationMapper;
import com.len.pdms.service.provider.session.SessionTemplate;
import com.len.util.BeanUtil;
import com.len.util.IDUtil;
import com.len.util.ReType;
import org.apache.dubbo.config.annotation.Service;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 需求管理实现
 */
@Service
public class IterationServiceImpl extends BaseServiceImpl<Iteration,String> implements IterationService {

    @Autowired
    private IterationMapper IterationMapper;

    @Autowired
    private IterationIssueMapper iterationIssueMapper;

    @Autowired
    private SessionTemplate sessionTemplate;

    @Override
    public BaseMapper<Iteration, String> getMappser() {
        return IterationMapper;
    }

    @Override
    public int add(IterationVo IterationVo) {
        Iteration Iteration = new Iteration();
        Iteration.setProjectId(sessionTemplate.getProjectId());
        Iteration.setTenantId(sessionTemplate.getTenantId());
        Iteration.setCreateDate(DateUtil.date());
        // 值拷贝
        BeanUtil.copyNotNullBean(IterationVo,Iteration);
        return this.insertSelective(Iteration);
    }

    @Override
    public int update(IterationVo IterationVo) {
        Iteration Iteration = new Iteration();
        BeanUtil.copyNotNullBean(IterationVo,Iteration);
        return IterationMapper.updateByPrimaryKeySelective(Iteration);
    }

    @Override
    public int remove(IterationVo IterationVo) {
        return IterationMapper.deleteByPrimaryKey(IterationVo.getId());
    }

    @Override
    public ReType selectList(IterationVo IterationVo,int page ,int limit) {
        IterationVo.setProjectId(sessionTemplate.getProjectId());
        IterationVo.setTenantId(sessionTemplate.getTenantId());
        List<Iteration> list = Lists.newArrayList();
        long total = 0;
        if(page > 0){
            Page<?> tPage = PageHelper.startPage(page,limit);
            list = IterationMapper.selectList(IterationVo);
            total = tPage.getTotal();
        }else{
            list = IterationMapper.selectList(IterationVo);
            total = list.size();
        }
        List<IterationVo> voList = Lists.newArrayList();
        for (Iteration Iteration: list) {
            IterationVo vo = new IterationVo();
            BeanUtil.copyNotNullBean(Iteration,vo);
            vo.setCreateDateText(DateUtil.formatDateTime(vo.getCreateDate()));
            vo.setStartDateText(DateUtil.formatDate(vo.getStartDate()));
            vo.setEndDateText(DateUtil.formatDate(vo.getEndDate()));
            voList.add(vo);
        }
        return new ReType(total,voList);
    }

    @Override
    public ReType selectIssueList(IterationIssueVo iterationIssueVo, int page, int limit) {
        Page<?> tPage = PageHelper.startPage(page,limit);
        List<IterationIssueVo> iterationIssues = iterationIssueMapper.selectList(iterationIssueVo);
        List<IterationIssueVo> voList = Lists.newArrayList();
        for (IterationIssueVo issue: iterationIssues) {
            IterationIssueVo vo = new IterationIssueVo();
            BeanUtil.copyNotNullBean(issue,vo);
            vo.setCreateDateText(DateUtil.formatDateTime(vo.getCreateDate()));
            voList.add(vo);
        }
        return new ReType(tPage.getTotal(),voList);
    }

    @Override
    public int addIssue(String id, String type, String json){
        JSONArray jsonArray = JSON.parseArray(json);
        for(int i = 0; i< jsonArray.size();i++){
            JSONObject obj = (JSONObject)jsonArray.get(i);
            String itemId = obj.getString("id");
            IterationIssue iterationIssue = new IterationIssue();
            iterationIssue.setId(IDUtil.genId());
            iterationIssue.setIssueId(itemId);
            iterationIssue.setIssueType(Integer.parseInt(type));
            iterationIssue.setIterationId(id);
            iterationIssueMapper.insert(iterationIssue);
        }
        return jsonArray.size();
    }

    @Override
    public int removeIssue(String id) {
        return iterationIssueMapper.deleteByPrimaryKey(id);
    }
}
