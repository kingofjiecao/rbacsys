package ltc.rbacsys.service.impl;

import ltc.rbacsys.mapper.PermissionMapper;
import ltc.rbacsys.service.PermissionCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionCheckServiceImpl implements PermissionCheckService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public boolean checkDeleteMessagePermission(Integer uid, Integer cid) {
        if (permissionMapper.selectDeleteMessagePermission(uid) != null) {
            return true;
        }
        if (permissionMapper.selectDeleteMessagePermissionWithCid(uid, cid) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUpdateMessagePermission(Integer uid, Integer cid, Integer gid) {
        if (permissionMapper.selectUpdateMessagePermission(uid) != null) {
            return true;
        }
        if (permissionMapper.selectUpdateMessagePermissionWithCid(gid,cid) != null) {
            return true;
        }
        if (permissionMapper.selectUpdateMessagePermissionByUid(uid, cid) != null) {
            return true;
        }
        return false;
//        查看是否有全局更新留言权限
//select * from (select * from tb_user join tb_user_role on uid = user_id) as t
// join tb_role_permission tp on t.role_id = tp.role_id where uid = 1（某个人） and permission_id=4（某项权限）;
//        查找是否是自己组的
//        select * from tb_message where user_id in (select user_id from tb_user where group_id=3) and cid = 2;
    }

    @Override
    public boolean checkUpdateUserPermission(Integer uid) {
        return false;
    }

    @Override
    public boolean checkDeleteUserPermission(Integer uid) {
        return false;
    }

    @Override
    public boolean checkUpdateGroupPermission(Integer uid) {
        return false;
    }

    @Override
    public boolean checkDeleteGroupPermission(Integer uid) {
        return false;
    }

    @Override
    public boolean checkCreateGroupPermission(Integer uid) {
        return false;
    }
}
