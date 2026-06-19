package com.jyk.domain.protocol.service;

import com.jyk.domain.protocol.model.entity.StorageCommandEntity;

import java.util.List;

/**
 * 协议存储接口
 *
 * @author best jyk
 * 2026/3/3 07:29
 */
public interface IProtocolStorage {

    List<Long> doStorage(StorageCommandEntity commandEntity);

    void deleteGatewayProtocol(Long protocolId);

}
