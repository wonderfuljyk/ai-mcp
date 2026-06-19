package com.jyk.domain.admin.gateway.service.gateway;

import com.jyk.domain.admin.gateway.adapter.repository.IGatewayRepository;
import com.jyk.domain.admin.gateway.model.entity.GatewayConfigCommandEntity;
import com.jyk.domain.admin.gateway.service.IGatewayConfigService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 网关配置服务
 *
 * @author best jyk
 * 2026/3/21 08:01
 */
@Slf4j
@Service
public class GatewayConfigService implements IGatewayConfigService {

    @Resource
    private IGatewayRepository repository;

    @Override
    public void saveGatewayConfig(GatewayConfigCommandEntity commandEntity) {
        repository.saveGatewayConfig(commandEntity);
    }

    @Override
    public void updateGatewayAuthStatus(GatewayConfigCommandEntity commandEntity) {
        repository.updateGatewayAuthStatus(commandEntity);
    }
}
