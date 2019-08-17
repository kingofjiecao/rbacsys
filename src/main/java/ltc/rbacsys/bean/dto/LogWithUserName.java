package ltc.rbacsys.bean.dto;

import lombok.Data;
import ltc.rbacsys.bean.Log;

@Data
public class LogWithUserName extends Log {
    private String userName;
}
