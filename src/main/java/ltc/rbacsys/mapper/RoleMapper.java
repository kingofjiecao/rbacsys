package ltc.rbacsys.mapper;

import ltc.rbacsys.bean.Role;
import ltc.rbacsys.bean.vo.RoleManageVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    List<Role> selectAllRoles();
    boolean deleteRoleByRid(Integer rid);
    Role selectRoleByRid(Integer rid);
    boolean updateRole(Role role);
    boolean insertRole(RoleManageVO roleManageVO);
}
