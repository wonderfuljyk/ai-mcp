package com.jyk.cases.admin;

import com.jyk.domain.protocol.model.entity.StorageCommandEntity;

/**
 * 协议配置管理
 *
 * @author best jyk
 * 2026/3/24 08:10
 */
public interface IAdminProtocolService {

    void saveGatewayProtocol(StorageCommandEntity commandEntity);

    void deleteGatewayProtocol(Long protocolId);

    void importGatewayProtocol(com.jyk.domain.protocol.model.entity.AnalysisCommandEntity commandEntity);

    java.util.List<com.jyk.domain.protocol.model.valobj.http.HTTPProtocolVO> analysisProtocol(com.jyk.domain.protocol.model.entity.AnalysisCommandEntity commandEntity);

}
