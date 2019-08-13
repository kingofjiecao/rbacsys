package ltc.rbacsys.service.impl;

import ltc.rbacsys.bean.UserRole;
import ltc.rbacsys.mapper.UserRoleMapper;
import ltc.rbacsys.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Override
    public boolean setRole(UserRole userRole) {
        if (userRoleMapper.selectUserRole(userRole) == null) {
            userRoleMapper.insertUserRole(userRole);
            return true;
        } else {
            userRoleMapper.updateUserRole(userRole);
            return true;
        }
    }
}
