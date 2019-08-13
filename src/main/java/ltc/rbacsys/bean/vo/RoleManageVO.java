package ltc.rbacsys.bean.vo;

import lombok.Data;
import ltc.rbacsys.bean.Role;

@Data
public class RoleManageVO extends Role {
    private Integer[] ids;
}
