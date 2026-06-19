package com.jyk.domain.admin.gateway.service;

import com.jyk.domain.admin.gateway.model.entity.GatewayConfigCommandEntity;

/**
 * 网关配置接口
 *
 * @author best jyk
 * 2026/3/21 07:56
 */
public interface IGatewayConfigService {

    void saveGatewayConfig(GatewayConfigCommandEntity commandEntity);

    void updateGatewayAuthStatus(GatewayConfigCommandEntity commandEntity);

}
