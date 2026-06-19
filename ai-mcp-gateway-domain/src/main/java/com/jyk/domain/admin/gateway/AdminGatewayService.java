package com.jyk.domain.admin.gateway;

import com.jyk.cases.admin.IAdminGatewayService;
import com.jyk.domain.gateway.model.entity.GatewayConfigCommandEntity;
import com.jyk.domain.gateway.model.entity.GatewayToolConfigCommandEntity;
import com.jyk.domain.gateway.service.IGatewayConfigService;
import com.jyk.domain.gateway.service.IGatewayToolConfigService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 网关配置管理
 *
 * @author best jyk
 * 2026/3/24 08:12
 */
@Slf4j
@Service
public class AdminGatewayService implements IAdminGatewayService {

    @Resource
    private IGatewayConfigService gatewayConfigService;

    @Resource
    private IGatewayToolConfigService gatewayToolConfigService;

    @Override
    public void saveGatewayConfig(GatewayConfigCommandEntity commandEntity) {
        gatewayConfigService.saveGatewayConfig(commandEntity);
    }

    @Override
    public void saveGatewayToolConfig(GatewayToolConfigCommandEntity commandEntity) {
        gatewayToolConfigService.saveGatewayToolConfig(commandEntity);
    }

    @Override
    public void deleteGatewayToolConfig(Long toolId) {
        gatewayToolConfigService.deleteGatewayToolConfig(toolId);
    }

}
