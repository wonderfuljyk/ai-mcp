package com.jyk.domain.gateway.adapter.repository;

import com.jyk.domain.gateway.model.entity.GatewayConfigCommandEntity;
import com.jyk.domain.gateway.model.entity.GatewayToolConfigCommandEntity;
import com.jyk.domain.gateway.model.valobj.GatewayToolConfigVO;

import java.util.List;

/**
 * 网关仓储服务接口
 *
 * @author best jyk
 * 2026/3/21 07:57
 */
public interface IGatewayRepository {

    void saveGatewayConfig(GatewayConfigCommandEntity commandEntity);

    void updateGatewayAuthStatus(GatewayConfigCommandEntity commandEntity);

    void saveGatewayToolConfig(GatewayToolConfigCommandEntity commandEntity);

    void updateGatewayToolProtocol(GatewayToolConfigCommandEntity commandEntity);

    void deleteGatewayToolConfig(Long toolId);

    List<GatewayToolConfigVO> queryGatewayToolConfigList(String gatewayId);

}

