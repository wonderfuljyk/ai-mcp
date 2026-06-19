package com.jyk.domain.session.service.message.handler;

import com.jyk.domain.session.model.valobj.McpSchemaVO;

/**
 * 处理请求接口
 *
 * @author best jyk
 * 2025/12/20 09:09
 */
public interface IRequestHandler {

    McpSchemaVO.JSONRPCResponse handle(String gatewayId, McpSchemaVO.JSONRPCRequest message);

}
