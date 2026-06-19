package com.jyk.cases.mcp.sse.session.factory;

import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import com.jyk.cases.mcp.sse.session.node.RootNode;

import com.jyk.domain.admin.session.model.valobj.SessionConfigVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

/**
 * MCP 会话服务工厂
 *
 * @author best jyk
 * 2025/12/13 09:09
 */
@Service
public class DefaultMcpSSESessionFactory {

    @Resource(name = "mcpSessionRootNode")
    private RootNode rootNode;

    public StrategyHandler<String, DynamicContext, Flux<ServerSentEvent<String>>> strategyHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        private String apiKey;

        private SessionConfigVO sessionConfigVO;
    }

}
