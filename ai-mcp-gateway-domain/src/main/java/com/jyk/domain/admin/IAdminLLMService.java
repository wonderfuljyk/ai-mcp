package com.jyk.domain.admin;

import com.jyk.api.dto.GatewayLLMRequestDTO;
import com.jyk.api.dto.GatewayLLMResponseDTO;

/**
 * LLM 对话模型服务，测试 MCP
 *
 * @author best jyk
 * 2026/4/8 07:50
 */
public interface IAdminLLMService {

    GatewayLLMResponseDTO testCallGateway(GatewayLLMRequestDTO requestDTO);

}
