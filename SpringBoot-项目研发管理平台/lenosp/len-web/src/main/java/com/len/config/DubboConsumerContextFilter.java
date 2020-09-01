package com.len.config;

import com.len.core.shiro.Principal;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;


@Activate
public class DubboConsumerContextFilter implements Filter {
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		// 处理session
		RpcContext.getContext().setAttachment("sessionId", Principal.getSession().getId().toString());
        //将sessionStr放入通用处理session中
        //TODO 处理代码
		return invoker.invoke(invocation);
	}

}