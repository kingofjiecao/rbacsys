package ltc.rbacsys.controller;

import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.annotation.Log;
import ltc.rbacsys.bean.Message;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.service.MessageService;
import ltc.rbacsys.service.PermissionCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    PermissionCheckService permissionCheckService;

    @Log("添加留言")
    @ResponseBody
    @RequestMapping("/createmessage")
    public String createMessage(Message message, HttpSession session) {
        JSONObject json = new JSONObject();
        Integer userid = ((User)session.getAttribute("user")).getUid();
        message.setCreateTime(new Date());
        message.setUserId(userid);
        if (messageService.addMessage(message)) {
            json.put("status", 200);
            json.put("message", "添加留言成功");
        } else {
            json.put("status", 400);
            json.put("message", "添加留言失败");
        }
        return json.toJSONString();
    }
    @Log("修改留言")
    @ResponseBody
    @RequestMapping("/modifymessage")
    public String modifyMessage(Message message, HttpSession session, HttpServletRequest req) {
        Integer uid = ((User)session.getAttribute("user")).getUid();
        Integer gid = message.getCid();
        System.out.println(message);
        JSONObject json = new JSONObject();
        if (!permissionCheckService.checkUpdateMessagePermission(uid, message.getCid(), gid)) {
            json.put("status", 400);
            json.put("message", "权限不足");
            req.setAttribute("status", false);
            return json.toJSONString();
        }
        if (messageService.modifyMessage(message)) {
            json.put("status", 200);
            json.put("message", "修改留言成功");
        } else {
            json.put("status", 400);
            json.put("message", "修改留言失败");
        }
        return json.toJSONString();
    }
    @Log("删除留言")
    @ResponseBody
    @RequestMapping("/deletemessage")
    public String deleteMessage(Integer cid, HttpSession session, HttpServletRequest req) {
        Integer uid = ((User)session.getAttribute("user")).getUid();
        JSONObject json = new JSONObject();
        if (!permissionCheckService.checkDeleteMessagePermission(uid, cid)) {
            json.put("status", 400);
            json.put("message", "权限不足");
            req.setAttribute("status", false);
            return json.toJSONString();
        }
        if (messageService.deleteMessage(cid)) {
            json.put("status", 200);
            json.put("message", "删除留言成功");
        } else {
            json.put("status", 400);
            json.put("message", "删除留言失败");
        }
        return json.toJSONString();
    }
}
