package com.jyk.domain.protocol.model.entity;

import com.jyk.domain.protocol.model.valobj.http.HTTPProtocolVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 存储协议实体
 *
 * @author best jyk
 * 2026/3/13 07:38
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageCommandEntity {

    /**
     * 协议列表数据
     */
    private List<HTTPProtocolVO> httpProtocolVOS;

}
