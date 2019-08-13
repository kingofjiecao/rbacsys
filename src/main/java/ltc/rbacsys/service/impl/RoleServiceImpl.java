package ltc.rbacsys.service.impl;

import ltc.rbacsys.bean.Role;
import ltc.rbacsys.bean.vo.RoleManageVO;
import ltc.rbacsys.mapper.PermissionMapper;
import ltc.rbacsys.mapper.RoleMapper;
import ltc.rbacsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public List<Role> getAllRoles() {
        return roleMapper.selectAllRoles();
    }

    @Override
    public boolean deleteRole(Integer rid) {
        boolean result2 = permissionMapper.deletePermissionByRid(rid);
        boolean result1 = roleMapper.deleteRoleByRid(rid);
        if (result1) {
            return true;
        }
        return false;
    }

    @Override
    public Role getRoleByRid(Integer rid) {
        return roleMapper.selectRoleByRid(rid);
    }

    @Override
    public boolean modifyRole(RoleManageVO roleManageVO) {
        List<Integer> ids = new ArrayList<Integer>();
        ids = Arrays.asList(roleManageVO.getIds());
        boolean result1 = roleMapper.updateRole(roleManageVO);
        boolean result2 = permissionMapper.deletePermissionByRid(roleManageVO.getRoleId());
        boolean result3 = permissionMapper.insertPermission(ids, roleManageVO.getRoleId());
        if (result1 && result3) {
            return true;
        }
        return false;
    }

    @Override
    public boolean createRole(RoleManageVO roleManageVO) {
        List<Integer> ids = new ArrayList<Integer>();
        ids = Arrays.asList(roleManageVO.getIds());
        if (roleMapper.insertRole(roleManageVO)) {
            if (permissionMapper.insertPermission(ids, roleManageVO.getRoleId())) {
                return true;
            }
        }
        return false;
    }
}
