package com.len.pdms.service.provider.config;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;


@Activate
public class DubboProviderContextFilter implements Filter {
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		// 处理session
		String sessionId = RpcContext.getContext().getAttachment("sessionId");
		System.err.println("sessionId:" + sessionId);

		//将sessionStr放入通用处理session中
        //TODO 处理代码
		return invoker.invoke(invocation);
	}

}