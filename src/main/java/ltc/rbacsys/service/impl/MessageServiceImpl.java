package ltc.rbacsys.service.impl;

import ltc.rbacsys.bean.Message;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.dto.MessageWithGroupId;
import ltc.rbacsys.bean.dto.MessageWithUserName;
import ltc.rbacsys.mapper.MessageMapper;
import ltc.rbacsys.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<MessageWithGroupId> getAllMessages() {
        return messageMapper.selectAllMessageWithGroupId();
    }

    @Override
    public List<MessageWithGroupId> getGroupMessages(User user) {
        return messageMapper.selectMessageWithGroupIdByGroupId(user);
    }

    @Override
    public List<MessageWithGroupId> getMyMessages(User user) {
        return messageMapper.selectMessageWithGroupIdByUserId(user);
    }

    @Override
    public boolean deleteMessage(Integer cid) {
        return messageMapper.deleteMessageById(cid);
    }

    @Override
    public List<MessageWithUserName> getAllMessageWithUserName() {
        return messageMapper.selectAllMessageWithUserName();
    }

    @Override
    public Message getOneMessageById(Integer cid) {
        return messageMapper.selectMessageByCid(cid);
    }

    @Override
    public boolean addMessage(Message message) {
        return messageMapper.insertMessage(message);
    }

    @Override
    public boolean modifyMessage(Message message) {
        return messageMapper.updateMessage(message);
    }
}
