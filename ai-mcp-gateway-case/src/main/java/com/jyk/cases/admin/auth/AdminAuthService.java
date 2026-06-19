package com.jyk.cases.admin.auth;

import com.jyk.cases.admin.IAdminAuthService;

import com.jyk.domain.admin.auth.model.entity.RegisterCommandEntity;
import com.jyk.domain.admin.auth.service.IAuthRegisterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 运营；认证配置管理
 *
 * @author best jyk
 * 2026/3/24 08:11
 */
@Slf4j
@Service("caseAdminAuthService")
public class AdminAuthService implements IAdminAuthService {

    @Resource
    private IAuthRegisterService authRegisterService;

    @Override
    public void saveGatewayAuth(RegisterCommandEntity commandEntity) {
        authRegisterService.register(commandEntity);
    }

    @Override
    public void deleteGatewayAuth(String gatewayId) {
        authRegisterService.deleteGatewayAuth(gatewayId);
    }

}
