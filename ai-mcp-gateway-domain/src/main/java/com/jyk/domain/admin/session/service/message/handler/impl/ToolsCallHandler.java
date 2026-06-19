package com.jyk.domain.admin.session.service.message.handler.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jyk.domain.admin.session.adapter.port.ISessionPort;
import com.jyk.domain.admin.session.adapter.repository.ISessionRepository;
import com.jyk.domain.admin.session.model.valobj.McpSchemaVO;
import com.jyk.domain.admin.session.model.valobj.gateway.McpToolProtocolConfigVO;
import com.jyk.domain.admin.session.service.message.handler.IRequestHandler;
import com.jyk.types.enums.McpErrorCodes;
import com.jyk.types.enums.ResponseCode;
import com.jyk.types.exception.AppException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 执行指定的工具调用
 *
 * @author best jyk
 * 2025/12/20 11:30
 */
@Slf4j
@Service("toolsCallHandler")
public class ToolsCallHandler implements IRequestHandler {

    @Resource
    private ISessionRepository repository;

    @Resource
    private ISessionPort port;

    @Override
    public McpSchemaVO.JSONRPCResponse handle(String gatewayId, McpSchemaVO.JSONRPCRequest message) {
        try {
            // 1. 转换参数
            McpSchemaVO.CallToolRequest callToolRequest =
                    McpSchemaVO.unmarshalFrom(message.params(), new TypeReference<>() {
                    });

            Object argumentsObj = callToolRequest.arguments();
            String toolName = callToolRequest.name();

            // 2. 查询协议信息
            McpToolProtocolConfigVO mcpToolProtocolConfigVO = repository.queryMcpGatewayProtocolConfig(gatewayId, toolName);
            if (null == mcpToolProtocolConfigVO) {
                throw new AppException(ResponseCode.METHOD_NOT_FOUND.getCode(), ResponseCode.METHOD_NOT_FOUND.getInfo());
            }

            // 2. 调用接口
            Object result = port.toolCall(mcpToolProtocolConfigVO.getHttpConfig(), argumentsObj);

            return new McpSchemaVO.JSONRPCResponse(McpSchemaVO.JSONRPC_VERSION, message.id(), Map.of(
                    "content", new Object[]{
                            Map.of(
                                    "type", "text",
                                    "text", result
                            ),

                    },
                    "isError", "false"
            ), null);

        } catch (Exception e) {
            return new McpSchemaVO.JSONRPCResponse(McpSchemaVO.JSONRPC_VERSION,
                    message.id(),
                    null,
                    new McpSchemaVO.JSONRPCResponse.JSONRPCError(McpErrorCodes.INVALID_PARAMS, e.getMessage(), null));

        }

    }

}
