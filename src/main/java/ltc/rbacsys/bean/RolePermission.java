package ltc.rbacsys.bean;

import lombok.Data;

@Data
public class RolePermission {
    private Integer prId;
    private Integer roleId;
    private Integer permissionId;
}
