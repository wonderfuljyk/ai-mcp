package com.jyk.cases.mcp.streamable.message.factory;

import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import com.jyk.cases.mcp.streamable.message.node.RootNode;
import com.jyk.domain.session.model.entity.HandleMessageCommandEntity;
import com.jyk.domain.session.model.valobj.SessionConfigVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * MCP Streamable 会话消息工厂
 * @author best jyk
 * 2026/5/20 07:34
 */
@Service
public class DefaultMcpStreamableMessageFactory {

    @Resource(name = "mcpStreamableMessageRootNode")
    private RootNode rootNode;

    public StrategyHandler<HandleMessageCommandEntity, DynamicContext, ResponseEntity<?>> strategyHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {
        private SessionConfigVO sessionConfigVO;
    }

}
