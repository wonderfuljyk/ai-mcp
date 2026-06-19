package com.jyk.domain.session.service;

import com.jyk.domain.session.model.entity.HandleMessageCommandEntity;
import com.jyk.domain.session.model.valobj.McpSchemaVO;

/**
 * 会话消息服务接口
 *
 * @author best jyk
 * 2025/12/20 08:49
 */
public interface ISessionMessageService {

    McpSchemaVO.JSONRPCResponse processHandlerMessage(String gatewayId, McpSchemaVO.JSONRPCMessage message);

    McpSchemaVO.JSONRPCResponse processHandlerMessage(HandleMessageCommandEntity commandEntity);

}
