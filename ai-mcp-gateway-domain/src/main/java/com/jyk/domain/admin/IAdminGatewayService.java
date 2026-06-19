package com.jyk.domain.admin;


import com.jyk.domain.admin.gateway.model.entity.GatewayConfigCommandEntity;
import com.jyk.domain.admin.gateway.model.entity.GatewayToolConfigCommandEntity;

/**
 * 网关配置管理
 *
 * @author best jyk
 * 2026/3/24 08:09
 */
public interface IAdminGatewayService {

    void saveGatewayConfig(GatewayConfigCommandEntity commandEntity);

    void saveGatewayToolConfig(GatewayToolConfigCommandEntity commandEntity);

    void deleteGatewayToolConfig(Long toolId);

}
