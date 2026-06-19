package com.jyk.domain.protocol.service.analysis.strategy;

import com.alibaba.fastjson.JSONObject;
import com.jyk.domain.protocol.model.valobj.http.HTTPProtocolVO;

import java.util.List;

/**
 * 协议解析策略接口
 *
 * @author best jyk
 */
public interface IProtocolAnalysisStrategy {

    void doAnalysis(JSONObject operation, JSONObject definitions, List<HTTPProtocolVO.ProtocolMapping> mappings);

}
