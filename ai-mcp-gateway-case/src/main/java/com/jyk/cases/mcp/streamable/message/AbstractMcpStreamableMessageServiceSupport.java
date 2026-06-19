package com.jyk.cases.mcp.streamable.message;

import cn.bugstack.wrench.design.framework.tree.AbstractMultiThreadStrategyRouter;
import com.jyk.cases.mcp.streamable.message.factory.DefaultMcpStreamableMessageFactory;

import com.jyk.domain.admin.session.model.entity.HandleMessageCommandEntity;
import com.jyk.domain.admin.session.service.ISessionManagementService;
import com.jyk.domain.admin.session.service.ISessionMessageService;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public abstract class AbstractMcpStreamableMessageServiceSupport extends AbstractMultiThreadStrategyRouter<HandleMessageCommandEntity, DefaultMcpStreamableMessageFactory.DynamicContext, ResponseEntity<?>> {

    @Resource
    protected ISessionMessageService serviceMessageService;

    @Resource
    protected ISessionManagementService sessionManagementService;

    @Override
    protected void multiThread(HandleMessageCommandEntity requestParameter, DefaultMcpStreamableMessageFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {

    }

}
