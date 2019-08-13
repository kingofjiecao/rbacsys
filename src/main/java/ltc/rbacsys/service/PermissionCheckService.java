package ltc.rbacsys.service;

public interface PermissionCheckService {
    boolean checkDeleteMessagePermission(Integer uid, Integer cid);
    boolean checkUpdateMessagePermission(Integer uid, Integer cid, Integer gid);
    boolean checkUpdateUserPermission(Integer uid);
    boolean checkDeleteUserPermission(Integer uid);
    boolean checkUpdateGroupPermission(Integer uid);
    boolean checkDeleteGroupPermission(Integer uid);
    boolean checkCreateGroupPermission(Integer uid);
}
