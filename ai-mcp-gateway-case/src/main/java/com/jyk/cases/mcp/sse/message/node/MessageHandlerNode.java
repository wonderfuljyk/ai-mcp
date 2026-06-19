package com.jyk.cases.mcp.sse.message.node;


import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyk.cases.mcp.sse.message.AbstractMcpMessageServiceSupport;
import com.jyk.cases.mcp.sse.message.factory.DefaultMcpMessageFactory;
import com.jyk.domain.admin.session.model.entity.HandleMessageCommandEntity;
import com.jyk.domain.admin.session.model.valobj.McpSchemaVO;
import com.jyk.domain.admin.session.model.valobj.SessionConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

/**
 * 消息节点
 *
 * @author best jyk
 * 2026/2/20 08:07
 */
@Slf4j
@Service("mcpMessageMessageHandlerNode")
public class MessageHandlerNode extends AbstractMcpMessageServiceSupport {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected ResponseEntity<Void> doApply(HandleMessageCommandEntity requestParameter, DefaultMcpMessageFactory.DynamicContext dynamicContext) throws Exception {
        log.info("消息处理 mcp message MessageHandlerNode:{}", requestParameter);

        McpSchemaVO.JSONRPCResponse jsonrpcResponse =
                serviceMessageService.processHandlerMessage(requestParameter.getGatewayId(), requestParameter.getJsonrpcMessage());

        if (null != jsonrpcResponse) {
            String responseJson = objectMapper.writeValueAsString(jsonrpcResponse);

            SessionConfigVO sessionConfigVO = dynamicContext.getSessionConfigVO();
            sessionConfigVO.getSink().tryEmitNext(ServerSentEvent.<String>builder()
                    .event("message")
                    .data(responseJson)
                    .build());
        }

        return ResponseEntity.accepted().build();
    }

    @Override
    public StrategyHandler<HandleMessageCommandEntity, DefaultMcpMessageFactory.DynamicContext, ResponseEntity<Void>> get(HandleMessageCommandEntity requestParameter, DefaultMcpMessageFactory.DynamicContext dynamicContext) throws Exception {
        return defaultStrategyHandler;
    }

}
