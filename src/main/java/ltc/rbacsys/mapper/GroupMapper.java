package ltc.rbacsys.mapper;

import ltc.rbacsys.bean.Group;
import ltc.rbacsys.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMapper {
    List<Group> selectAllGroup();
    Group selectGroupByUserId(User user);
    boolean deleteGroupByGid(Integer gid);
    Group selectGroupByGid(Integer gid);
    boolean updateGroup(Group group);
    boolean insertGroup(Group group);
}
