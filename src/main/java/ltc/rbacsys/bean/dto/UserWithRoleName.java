package ltc.rbacsys.bean.dto;

import lombok.Data;
import ltc.rbacsys.bean.User;

@Data
public class UserWithRoleName extends User {
    private String roleName;
    private Integer roleId;
}
