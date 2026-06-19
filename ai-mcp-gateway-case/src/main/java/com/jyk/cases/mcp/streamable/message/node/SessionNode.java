package com.jyk.cases.mcp.streamable.message.node;

import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import com.jyk.cases.mcp.streamable.message.AbstractMcpStreamableMessageServiceSupport;
import com.jyk.cases.mcp.streamable.message.factory.DefaultMcpStreamableMessageFactory;
import com.jyk.domain.session.model.entity.HandleMessageCommandEntity;
import com.jyk.domain.session.model.valobj.SessionConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 会话节点
 *
 * @author best jyk
 * 2026/5/20 07:40
 */
@Slf4j
@Service("mcpStreamableMessageSessionNode")
public class SessionNode extends AbstractMcpStreamableMessageServiceSupport {

    @Resource(name = "mcpStreamableMessageHandlerNode")
    private MessageHandlerNode messageHandlerNode;

    @Override
    protected ResponseEntity<?> doApply(HandleMessageCommandEntity requestParameter, DefaultMcpStreamableMessageFactory.DynamicContext dynamicContext) throws Exception {
        log.info("Streamable 消息处理 SessionNode:{}", requestParameter);

        SessionConfigVO sessionConfigVO = sessionManagementService.getSession(requestParameter.getSessionId());
        if (null == sessionConfigVO) {
            log.warn("Streamable 会话不存在或已过期，gatewayId:{} sessionId:{}", requestParameter.getGatewayId(), requestParameter.getSessionId());
            return ResponseEntity.notFound().build();
        }

        dynamicContext.setSessionConfigVO(sessionConfigVO);

        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<HandleMessageCommandEntity, DefaultMcpStreamableMessageFactory.DynamicContext, ResponseEntity<?>> get(HandleMessageCommandEntity requestParameter, DefaultMcpStreamableMessageFactory.DynamicContext dynamicContext) throws Exception {
        return messageHandlerNode;
    }

}
