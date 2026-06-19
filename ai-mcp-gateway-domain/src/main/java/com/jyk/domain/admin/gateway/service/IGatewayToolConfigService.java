package com.jyk.domain.admin.gateway.service;

import com.jyk.domain.admin.gateway.model.entity.GatewayToolConfigCommandEntity;
import com.jyk.domain.admin.gateway.model.valobj.GatewayToolConfigVO;

import java.util.List;

/**
 * 网关工具配置服务接口
 *
 * @author best jyk
 * 2026/3/21 09:43
 */
public interface IGatewayToolConfigService {

    void saveGatewayToolConfig(GatewayToolConfigCommandEntity commandEntity);

    void updateGatewayToolProtocol(GatewayToolConfigCommandEntity commandEntity);

    void deleteGatewayToolConfig(Long toolId);

    List<GatewayToolConfigVO> queryGatewayToolConfigList(String gatewayId);

}
