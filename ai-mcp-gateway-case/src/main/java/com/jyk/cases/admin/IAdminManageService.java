package com.jyk.cases.admin;

import com.jyk.domain.admin.model.entity.*;
import com.jyk.domain.admin.model.entity.GatewayAuthConfigEntity;
import com.jyk.domain.admin.model.entity.GatewayAuthPageEntity;
import com.jyk.domain.admin.model.entity.GatewayAuthQueryEntity;
import com.jyk.domain.admin.model.entity.GatewayConfigEntity;
import com.jyk.domain.admin.model.entity.GatewayConfigPageEntity;
import com.jyk.domain.admin.model.entity.GatewayConfigQueryEntity;
import com.jyk.domain.admin.model.entity.GatewayProtocolConfigEntity;
import com.jyk.domain.admin.model.entity.GatewayProtocolPageEntity;
import com.jyk.domain.admin.model.entity.GatewayProtocolQueryEntity;
import com.jyk.domain.admin.model.entity.GatewayToolConfigEntity;
import com.jyk.domain.admin.model.entity.GatewayToolPageEntity;
import com.jyk.domain.admin.model.entity.GatewayToolQueryEntity;

import java.util.List;

/**
 * 运营管理
 *
 * @author best jyk
 * 2026/3/26
 */
public interface IAdminManageService {

    List<GatewayConfigEntity> queryGatewayConfigList();

    GatewayConfigPageEntity queryGatewayConfigPage(GatewayConfigQueryEntity queryEntity);

    List<GatewayToolConfigEntity> queryGatewayToolList();

    GatewayToolPageEntity queryGatewayToolPage(GatewayToolQueryEntity queryEntity);

    List<GatewayToolConfigEntity> queryGatewayToolListByGatewayId(String gatewayId);

    List<GatewayProtocolConfigEntity> queryGatewayProtocolList();

    GatewayProtocolPageEntity queryGatewayProtocolPage(GatewayProtocolQueryEntity queryEntity);

    List<GatewayProtocolConfigEntity> queryGatewayProtocolListByGatewayId(String gatewayId);

    List<GatewayAuthConfigEntity> queryGatewayAuthList();

    GatewayAuthPageEntity queryGatewayAuthPage(GatewayAuthQueryEntity queryEntity);

    /**
     * 根据网关ID查询该网关下的认证配置列表
     */
    List<GatewayAuthConfigEntity> queryGatewayAuthListByGatewayId(String gatewayId);

}