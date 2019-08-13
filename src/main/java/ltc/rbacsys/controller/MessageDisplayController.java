package ltc.rbacsys.controller;

import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.bean.Message;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.dto.MessageWithGroupId;
import ltc.rbacsys.bean.dto.MessageWithUserName;
import ltc.rbacsys.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MessageDisplayController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/getallmessage")
    public String getAllMessage(){
        JSONObject json = new JSONObject();
        List<MessageWithGroupId> messages = messageService.getAllMessages();
        json.put("messages", messages);
        return json.toJSONString();
    }
    @RequestMapping("/getgroupmessage")
    public String getGroupMessage(HttpSession session){
        User user = (User)session.getAttribute("user");
        JSONObject json = new JSONObject();
        List<MessageWithGroupId> messages = messageService.getGroupMessages(user);
        json.put("messages", messages);
        return json.toJSONString();
    }
    @RequestMapping("/getmymessage")
    public String getMyMessage(HttpSession session){
        User user = (User)session.getAttribute("user");
        JSONObject json = new JSONObject();
        List<MessageWithGroupId> messages = messageService.getMyMessages(user);
        json.put("messages", messages);
        return json.toJSONString();
    }
    @RequestMapping("/getallmessagewithname")
    public String getAllMessageWithName() {
        List<MessageWithUserName> messages = messageService.getAllMessageWithUserName();
        JSONObject json = new JSONObject();
        json.put("messages", messages);
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getmodifymessageinfo")
    public String getModifyMessage(Integer cid) {
        Message message = messageService.getOneMessageById(cid);
        JSONObject json = new JSONObject();
        json.put("message", message);
        return json.toJSONString();
    }
}
