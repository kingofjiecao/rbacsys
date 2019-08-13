package ltc.rbacsys.mapper;

import ltc.rbacsys.bean.Message;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.dto.MessageWithGroupId;
import ltc.rbacsys.bean.dto.MessageWithUserName;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    List<MessageWithGroupId> selectAllMessageWithGroupId();
    List<MessageWithGroupId> selectMessageWithGroupIdByGroupId(User user);
    List<MessageWithGroupId> selectMessageWithGroupIdByUserId(User user);
    boolean deleteMessageById(Integer cid);
    List<MessageWithUserName> selectAllMessageWithUserName();
    Message selectMessageByCid(Integer cid);
    boolean insertMessage(Message message);
    boolean updateMessage(Message message);
}
