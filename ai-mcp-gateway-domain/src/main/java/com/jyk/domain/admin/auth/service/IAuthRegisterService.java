package com.jyk.domain.admin.auth.service;

import com.jyk.domain.admin.auth.model.entity.RegisterCommandEntity;

/**
 * 认证服务注册接口
 *
 * @author best jyk
 * 2026/3/13 08:34
 */
public interface IAuthRegisterService {

    /**
     * 注册
     */
    void register(RegisterCommandEntity commandEntity);

    /**
     * 删除
     */
    void deleteGatewayAuth(String gatewayId);

}
