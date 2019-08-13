package ltc.rbacsys.service;

import ltc.rbacsys.bean.Role;
import ltc.rbacsys.bean.vo.RoleManageVO;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    boolean deleteRole(Integer rid);
    Role getRoleByRid(Integer rid);
    boolean modifyRole(RoleManageVO roleManageVO);
    boolean createRole(RoleManageVO roleManageVO);
}
