package ltc.rbacsys.service.impl;

import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.dto.UserWithRoleName;
import ltc.rbacsys.mapper.UserMapper;
import ltc.rbacsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.selectUserByUsernameAndPassword(user);
    }

    @Override
    public boolean register(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public UserWithRoleName getUserWithRoleName(User user) {
        return userMapper.selectUserWithRoleNameByUser(user);
    }

    @Override
    public boolean modifyUserInfo(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User findUser(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public boolean quitGroup(User user) {
        return userMapper.resetGroupId(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public boolean deleteUser(Integer uid) {
        return userMapper.deleteUser(uid);
    }
}
