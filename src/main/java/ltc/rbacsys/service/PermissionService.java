package ltc.rbacsys.service;

import ltc.rbacsys.bean.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getAllPermission();
    List<Permission> getPermissionsByRid(Integer rid);
}
