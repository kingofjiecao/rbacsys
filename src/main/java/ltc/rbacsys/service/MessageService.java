package ltc.rbacsys.service;

import ltc.rbacsys.bean.Message;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.dto.MessageWithGroupId;
import ltc.rbacsys.bean.dto.MessageWithUserName;

import java.util.List;

public interface MessageService {
    List<MessageWithGroupId> getAllMessages();
    List<MessageWithGroupId> getGroupMessages(User user);
    List<MessageWithGroupId> getMyMessages(User user);
    boolean deleteMessage(Integer cid);
    List<MessageWithUserName> getAllMessageWithUserName();
    Message getOneMessageById(Integer cid);
    boolean addMessage(Message message);
    boolean modifyMessage(Message message);
}
