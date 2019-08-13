package ltc.rbacsys.service.impl;

import ltc.rbacsys.bean.Permission;
import ltc.rbacsys.mapper.PermissionMapper;
import ltc.rbacsys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> getAllPermission() {
        return permissionMapper.selectAllPermission();
    }

    @Override
    public List<Permission> getPermissionsByRid(Integer rid) {
        return permissionMapper.selectPermissionByRid(rid);
    }
}
