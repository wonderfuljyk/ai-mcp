package com.jyk.domain.protocol.adapter.repository;

import com.jyk.domain.protocol.model.valobj.http.HTTPProtocolVO;

import java.util.List;

/**
 * 协议仓储服务接口
 *
 * @author best jyk
 * 2026/3/13 08:21
 */
public interface IProtocolRepository {

    List<Long> saveHttpProtocolAndMapping(List<HTTPProtocolVO> httpProtocolVOS);

    void deleteGatewayProtocol(Long protocolId);

}
