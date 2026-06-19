package com.jyk.cases.distributed;

import com.jyk.domain.session.model.valobj.SessionSyncEventVO;

import java.util.function.Consumer;

/**
 * 分布式服务接口
 *
 * @author best jyk
 * 2026/6/9 23:25
 */
public interface IDistributedService {

    void handleSessionSyncEvent(SessionSyncEventVO event);

    void subscribeSessionSyncEvent(Consumer<SessionSyncEventVO> consumer);

}
