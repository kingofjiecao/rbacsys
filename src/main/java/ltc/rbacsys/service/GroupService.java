package ltc.rbacsys.service;

import ltc.rbacsys.bean.Group;
import ltc.rbacsys.bean.User;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroup();
    Group getMyGroup(User user);
    boolean deleteGroup(Integer gid);
    Group findGroup(Integer gid);
    boolean modifyGroup(Group group);
    boolean createGroup(Group group);
}
