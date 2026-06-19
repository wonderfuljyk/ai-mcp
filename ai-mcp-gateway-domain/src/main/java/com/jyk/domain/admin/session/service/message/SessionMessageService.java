package com.jyk.domain.admin.session.service.message;

import com.alibaba.fastjson.JSON;
import com.jyk.domain.admin.session.model.entity.HandleMessageCommandEntity;
import com.jyk.domain.admin.session.model.valobj.McpSchemaVO;
import com.jyk.domain.admin.session.model.valobj.enums.SessionMessageHandlerMethodEnum;
import com.jyk.domain.admin.session.service.ISessionMessageService;
import com.jyk.domain.admin.session.service.message.handler.IRequestHandler;
import com.jyk.types.exception.AppException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.jyk.types.enums.ResponseCode.METHOD_NOT_FOUND;

/**
 * 会话消息服务
 *
 * @author best jyk
 * 2025/12/20 08:50
 */
@Slf4j
@Service
public class SessionMessageService implements ISessionMessageService {

    @Resource
    private Map<String, IRequestHandler> requestHandlerMap;

    @Override
    public McpSchemaVO.JSONRPCResponse processHandlerMessage(String gatewayId, McpSchemaVO.JSONRPCMessage message) {

        if (message instanceof McpSchemaVO.JSONRPCResponse response) {
            log.info("收到结果消息");
        }

        if (message instanceof McpSchemaVO.JSONRPCRequest request) {
            String method = request.method();
            log.info("开始处理请求，方法: {}", method);

            SessionMessageHandlerMethodEnum sessionMessageHandlerMethodEnum = SessionMessageHandlerMethodEnum.getByMethod(method);
            if (null == sessionMessageHandlerMethodEnum) {
                throw new AppException(METHOD_NOT_FOUND.getCode(), METHOD_NOT_FOUND.getInfo());
            }

            String handlerName = sessionMessageHandlerMethodEnum.getHandlerName();
            IRequestHandler requestHandler = requestHandlerMap.get(handlerName);

            if (null == requestHandler) {
                throw new AppException(METHOD_NOT_FOUND.getCode(), METHOD_NOT_FOUND.getInfo());
            }

            // 使用枚举策略模式处理请求
            return requestHandler.handle(gatewayId, request);
        }

        if (message instanceof McpSchemaVO.JSONRPCNotification notification) {
            log.info("收到即将处理的通知 {} {}", notification.method(), JSON.toJSONString(notification.params()));
        }

        return null;

    }

    @Override
    public McpSchemaVO.JSONRPCResponse processHandlerMessage(HandleMessageCommandEntity commandEntity) {
        return processHandlerMessage(commandEntity.getGatewayId(), commandEntity.getJsonrpcMessage());
    }

}
