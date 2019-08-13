package ltc.rbacsys.bean.dto;

import lombok.Data;
import ltc.rbacsys.bean.Message;

@Data
public class MessageWithGroupId extends Message {
    private Integer groupId;
    private String  userName;
}
