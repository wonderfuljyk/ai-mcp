package com.jyk.domain.admin.session.service.message.handler.impl;


import com.jyk.domain.admin.session.model.valobj.McpSchemaVO;
import com.jyk.domain.admin.session.service.message.handler.IRequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 返回可用资源列表
 *
 * @author best jyk
 * 2025/12/20 11:31
 */
@Slf4j
@Service("resourcesListHandler")
public class ResourcesListHandler implements IRequestHandler {

    @Override
    public McpSchemaVO.JSONRPCResponse handle(String gatewayId, McpSchemaVO.JSONRPCRequest message) {
        return new McpSchemaVO.JSONRPCResponse("2.0", message.id(), Map.of(
                "resources", Map.of(
                        "resources", new Object[]{}
                )
        ), null);
    }

}
