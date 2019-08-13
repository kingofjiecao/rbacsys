package ltc.rbacsys.service.impl;

import ltc.rbacsys.bean.Group;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.mapper.GroupMapper;
import ltc.rbacsys.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;
    @Override
    public List<Group> getAllGroup() {
        return groupMapper.selectAllGroup();
    }

    @Override
    public Group getMyGroup(User user) {
        return groupMapper.selectGroupByUserId(user);
    }

    @Override
    public boolean deleteGroup(Integer gid) {
        return groupMapper.deleteGroupByGid(gid);
    }

    @Override
    public Group findGroup(Integer gid) {
        return groupMapper.selectGroupByGid(gid);
    }

    @Override
    public boolean modifyGroup(Group group) {
        return groupMapper.updateGroup(group);
    }

    @Override
    public boolean createGroup(Group group) {
        return groupMapper.insertGroup(group);
    }
}
