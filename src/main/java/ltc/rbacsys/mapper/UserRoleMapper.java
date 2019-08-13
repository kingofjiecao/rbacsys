package ltc.rbacsys.mapper;

import ltc.rbacsys.bean.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    boolean insertUserRole(UserRole userRole);
    boolean updateUserRole(UserRole userRole);
    UserRole selectUserRole(UserRole userRole);
}
