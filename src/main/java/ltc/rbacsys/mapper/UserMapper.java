package ltc.rbacsys.mapper;

import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.dto.UserWithRoleName;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User selectUserByUsernameAndPassword(User user);
    boolean insertUser(User user);
    UserWithRoleName selectUserWithRoleNameByUser(User user);
    boolean updateUser(User user);
    User selectUser(User user);
    boolean resetGroupId(User u);
    List<User> selectAllUser();
    boolean deleteUser(Integer uid);
}
