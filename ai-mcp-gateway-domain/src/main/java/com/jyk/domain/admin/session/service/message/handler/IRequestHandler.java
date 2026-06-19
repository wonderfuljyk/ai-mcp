package com.jyk.domain.admin.session.service.message.handler;

import com.jyk.domain.admin.session.model.valobj.McpSchemaVO;

/**
 * 处理请求接口
 *
 * @author best jyk
 * 2025/12/20 09:09
 */
public interface IRequestHandler {

    McpSchemaVO.JSONRPCResponse handle(String gatewayId, McpSchemaVO.JSONRPCRequest message);

}
