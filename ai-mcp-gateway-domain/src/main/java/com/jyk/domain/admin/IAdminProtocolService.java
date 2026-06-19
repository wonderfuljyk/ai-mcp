package com.jyk.domain.admin;


import com.jyk.domain.admin.protocol.model.entity.AnalysisCommandEntity;
import com.jyk.domain.admin.protocol.model.entity.StorageCommandEntity;
import com.jyk.domain.admin.protocol.model.valobj.http.HTTPProtocolVO;

/**
 * 协议配置管理
 *
 * @author best jyk
 * 2026/3/24 08:10
 */
public interface IAdminProtocolService {

    void saveGatewayProtocol(StorageCommandEntity commandEntity);

    void deleteGatewayProtocol(Long protocolId);

    void importGatewayProtocol(AnalysisCommandEntity commandEntity);

    java.util.List<HTTPProtocolVO> analysisProtocol(AnalysisCommandEntity commandEntity);

}
