package ltc.rbacsys.bean;

import lombok.Data;

@Data
public class User {
    private Integer uid;
    private String userName;
    private String password;
    private String email;
    private String number;
    private Integer groupId;
    private boolean isAdmin;
}
