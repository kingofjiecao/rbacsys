package ltc.rbacsys.service;

import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.dto.UserWithRoleName;

import java.util.List;

public interface UserService {
    User login(User user);
    boolean register(User user);
    UserWithRoleName getUserWithRoleName(User user);
    boolean modifyUserInfo(User user);
    User findUser(User user);
    boolean quitGroup(User user);
    List<User> getAllUser();
    boolean deleteUser(Integer uid);
}
