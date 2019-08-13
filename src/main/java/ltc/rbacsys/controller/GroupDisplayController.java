package ltc.rbacsys.controller;

import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.bean.Group;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class GroupDisplayController {
    @Autowired
    GroupService groupService;
    @RequestMapping("/getgroupinfo")
    public String getGroupInfo() {
        List<Group> groups = groupService.getAllGroup();
        JSONObject json = new JSONObject();
        json.put("groups", groups);
        System.out.println(groups);
        return json.toJSONString();
    }
    @RequestMapping("/getmygroupinfo")
    public String getMyGroupInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        JSONObject json = new JSONObject();
        Group group = groupService.getMyGroup(user);
        if (group != null) {
            json.put("status", 200);
            json.put("group", group);
        } else {
            json.put("status", 403);
            json.put("message", "你还未加入任何组");
        }
        return json.toJSONString();
    }
    @RequestMapping("/getmodifygroupinfo")
    public String getModifyGroupInfo(Integer gid) {
        Group group = groupService.findGroup(gid);
        JSONObject json = new JSONObject();
        json.put("group", group);
        return json.toJSONString();
    }
}
