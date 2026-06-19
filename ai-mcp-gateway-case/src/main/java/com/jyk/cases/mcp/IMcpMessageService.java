package com.jyk.cases.mcp;

import com.jyk.domain.session.model.entity.HandleMessageCommandEntity;
import org.springframework.http.ResponseEntity;

/**
 * MCP 消息服务接口
 *
 * @author best jyk
 * 2025/12/13 09:08
 */
public interface IMcpMessageService<T> {

    ResponseEntity<T> handleMessage(HandleMessageCommandEntity commandEntity) throws Exception;

}
