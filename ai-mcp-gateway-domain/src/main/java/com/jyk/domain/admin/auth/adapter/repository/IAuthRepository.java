package com.jyk.domain.admin.auth.adapter.repository;

import com.jyk.domain.admin.auth.model.entity.LicenseCommandEntity;
import com.jyk.domain.admin.auth.model.valobj.McpGatewayAuthVO;
import com.jyk.domain.admin.auth.model.valobj.enums.AuthStatusEnum;

/**
 * 鉴权仓储服务接口
 *
 * @author best jyk
 * 2026/2/22 10:57
 */
public interface IAuthRepository {

    void saveGatewayAuth(McpGatewayAuthVO mcpGatewayAuthVO);

    boolean validate(String gatewayId, String apiKey);

    int queryEffectiveGatewayAuthCount(String gatewayId);

    McpGatewayAuthVO queryEffectiveGatewayAuthInfo(LicenseCommandEntity commandEntity);

    AuthStatusEnum.GatewayConfig queryGatewayAuthStatus(String gatewayId);

    void deleteGatewayAuth(String gatewayId);

}
