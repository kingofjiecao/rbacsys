package ltc.rbacsys.controller;

import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.annotation.Log;
import ltc.rbacsys.bean.Group;
import ltc.rbacsys.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GroupController {
    @Autowired
    GroupService groupService;

    @Log("删除用户组")
    @ResponseBody
    @RequestMapping("/deletegroup")
    public String deleteGroup(Integer gid) {
        JSONObject json = new JSONObject();
        if (groupService.deleteGroup(gid)) {
            json.put("status", 200);
            json.put("message", "删除成功");
        } else {
            json.put("status", 400);
            json.put("message", "删除失败");
        }
        return json.toJSONString();
    }
    @Log("修改用户组")
    @ResponseBody
    @RequestMapping("/modifygroupinfo")
    public String modifyGroupInfo(Group group) {
        JSONObject json = new JSONObject();
        if (groupService.modifyGroup(group)) {
            json.put("status", 200);
            json.put("message", "修改成功");
        } else {
            json.put("status", 400);
            json.put("message", "修改失败");
        }
        return json.toJSONString();
    }

    @Log("新建用户组")
    @ResponseBody
    @RequestMapping("/creategroup")
    public String createGroup(Group group) {
        JSONObject json = new JSONObject();
        if ((!"".equals(group.getGroupInfo())) && (!"".equals(group.getGroupName()))) {
            if (groupService.createGroup(group)) {
                json.put("status", 200);
                json.put("message", "创建成功");
            } else {
                json.put("status", 400);
                json.put("message", "创建失败");
            }
        } else {
            json.put("status", 400);
            json.put("message", "组名和描述不能为空");
        }
        return json.toJSONString();
    }
}
