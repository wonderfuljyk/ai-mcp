package com.jyk.test.domain.session.message;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyk.domain.session.model.valobj.McpSchemaVO;
import com.jyk.domain.session.service.message.handler.impl.ToolsCallHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ToolsCallHandlerTest {

    @Resource
    private ToolsCallHandler toolsCallHandler;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test_post() throws JsonProcessingException {

        String jsonStr = """
                {"name":"JavaSDKMCPClient_getCompanyEmployee","arguments":{"xxxRequest01":{"city":"beijing","company":{"name":"jd","type":""}}}}
                """;

        McpSchemaVO.JSONRPCResponse handle = toolsCallHandler.handle("gateway_001",
                new McpSchemaVO.JSONRPCRequest("2.0", "tools/call", "a355a5f7-0",  objectMapper.readValue(jsonStr, Map.class)));

        log.info("测试结果(post):{}", JSON.toJSONString(handle));
    }

    @Test
    public void test_get() throws JsonProcessingException {
        String jsonStr = """
                {"name":"JavaSDKMCPClient_queryAiClientById","arguments":{"req":{"id":10001}}}
                """;

        McpSchemaVO.JSONRPCResponse handle = toolsCallHandler.handle("gateway_002",
                new McpSchemaVO.JSONRPCRequest("2.0", "tools/call", "a355a5f7-0",  objectMapper.readValue(jsonStr, Map.class)));

        log.info("测试结果(get){}", JSON.toJSONString(handle));
    }

}
