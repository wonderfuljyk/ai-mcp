package com.jyk.domain.admin;


import com.jyk.domain.admin.auth.model.entity.RegisterCommandEntity;

/**
 * 运营；认证配置管理
 *
 * @author best jyk
 * 2026/3/24 08:11
 */
public interface IAdminAuthService {

    void saveGatewayAuth(RegisterCommandEntity commandEntity);

    void deleteGatewayAuth(String gatewayId);

}
