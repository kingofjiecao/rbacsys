package ltc.rbacsys.bean.dto;

import lombok.Data;
import ltc.rbacsys.bean.Message;

@Data
public class MessageWithUserName extends Message {
    private String userName;
}
