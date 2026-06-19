package com.jyk.domain.admin.auth.service;

import com.jyk.domain.admin.auth.model.entity.LicenseCommandEntity;

/**
 * 权限证书服务接口
 *
 * @author best jyk
 * 2026/2/22 10:11
 */
public interface IAuthLicenseService {

    boolean checkLicense(LicenseCommandEntity commandEntity);

}
