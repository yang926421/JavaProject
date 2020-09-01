package com.len.pdms.service.provider.session;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.len.base.CurrentUser;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 用户Session操作类
 */
@Component
public class SessionTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    public Session getSession(){
        String sessionId = RpcContext.getContext().getAttachment("sessionId");
        String key = "shiro-activeSessionCache:" + sessionId;
        return (Session) redisTemplate.opsForValue().get(key.getBytes());
    }

    public String getSessionId(){
        return getSession().getId().toString();
    }

    public CurrentUser getCurrentUser(){
        return (CurrentUser)getSession().getAttribute("currentPrincipal");
    }

    public String getTenantId(){
        return (String)getSession().getAttribute("globalTenantId");
    }

    public String getProjectId(){
        return (String)getSession().getAttribute("globalProjectId");
    }

}
