package com.jyk.cases.mcp.streamable.message.node;

import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyk.cases.mcp.streamable.message.AbstractMcpStreamableMessageServiceSupport;
import com.jyk.cases.mcp.streamable.message.factory.DefaultMcpStreamableMessageFactory;
import com.jyk.domain.session.model.entity.HandleMessageCommandEntity;
import com.jyk.domain.session.model.valobj.McpSchemaVO;
import com.jyk.domain.session.model.valobj.SessionConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

/**
 * Streamable 消息处理节点
 *
 * @author best jyk
 * 2026/5/25 08:00
 */
@Slf4j
@Service("mcpStreamableMessageHandlerNode")
public class MessageHandlerNode extends AbstractMcpStreamableMessageServiceSupport {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected ResponseEntity<?> doApply(HandleMessageCommandEntity requestParameter, DefaultMcpStreamableMessageFactory.DynamicContext dynamicContext) throws Exception {
        log.info("Streamable 消息处理 MessageHandlerNode:{}", requestParameter);

        McpSchemaVO.JSONRPCResponse jsonrpcResponse = serviceMessageService.processHandlerMessage(requestParameter);
        if (null != jsonrpcResponse) {
            String responseJson = objectMapper.writeValueAsString(jsonrpcResponse);

            SessionConfigVO sessionConfigVO = dynamicContext.getSessionConfigVO();
            sessionConfigVO.getSink().tryEmitNext(ServerSentEvent.<String>builder()
                    .id(sessionConfigVO.getSessionId())
                    .event("message")
                    .data(responseJson)
                    .build());
        }

        return ResponseEntity.accepted().build();
    }

    @Override
    public StrategyHandler<HandleMessageCommandEntity, DefaultMcpStreamableMessageFactory.DynamicContext, ResponseEntity<?>> get(HandleMessageCommandEntity requestParameter, DefaultMcpStreamableMessageFactory.DynamicContext dynamicContext) throws Exception {
        return defaultStrategyHandler;
    }

}
