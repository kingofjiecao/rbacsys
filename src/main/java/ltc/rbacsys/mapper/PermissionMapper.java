package ltc.rbacsys.mapper;

import ltc.rbacsys.bean.Message;
import ltc.rbacsys.bean.Permission;
import ltc.rbacsys.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PermissionMapper {
    Message selectDeleteMessagePermission(Integer uid);
    Message selectDeleteMessagePermissionWithCid(@Param("uid") Integer uid, @Param("cid") Integer cid);
    User selectUpdateMessagePermission(Integer uid);
    Message selectUpdateMessagePermissionWithCid(@Param("groupId") Integer groupId, @Param("cid") Integer cid);
    Message selectUpdateMessagePermissionByUid(@Param("uid") Integer uid, @Param("cid") Integer cid);
    List<Permission> selectAllPermission();
    List<Permission> selectPermissionByRid(Integer rid);
    boolean insertPermission(@Param("ids") Collection ids, @Param("roleId") Integer roleId);
    boolean deletePermissionByRid(Integer rid);
}
