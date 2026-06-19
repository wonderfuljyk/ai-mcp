package com.jyk.domain.admin.auth.service;

import com.jyk.domain.admin.auth.model.entity.RateLimitCommandEntity;

/**
 * 调用限制服务接口
 *
 * @author best jyk
 * 2026/2/22 10:17
 */
public interface IAuthRateLimitService {

    /**
     * 限流操作
     * true - 限流
     * false - 未限流
     */
    boolean rateLimit(RateLimitCommandEntity commandEntity);

}
