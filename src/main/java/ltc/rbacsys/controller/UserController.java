package ltc.rbacsys.controller;


import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.UserRole;
import ltc.rbacsys.bean.dto.UserWithRoleName;
import ltc.rbacsys.service.UserRoleService;
import ltc.rbacsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @ResponseBody
    @RequestMapping("modifyuserinfo")
    public String modifyUserInfo(User user, HttpSession session){
        JSONObject json = new JSONObject();
        if (userService.modifyUserInfo(user)) {
            json.put("status", 200);
            json.put("message", "修改成功,请重新登录");
            session.removeAttribute("user");
        } else {
            json.put("status", 400);
            json.put("message", "修改失败");
        }
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/joingroup")
    public String joinGroup(HttpServletRequest req) {
        Integer groupId = Integer.parseInt(req.getParameter("groupId"));
        Integer uid = ((User)req.getSession().getAttribute("user")).getUid();
        User user = new User();
        user.setGroupId(groupId);
        user.setUid(uid);
        JSONObject json = new JSONObject();

        User u = userService.findUser(user);
        if (u.getGroupId() != null) {
            json.put("status", 400);
            json.put("message", "加入失败，你已加入了一个组，请先退组");
        } else {
            userService.modifyUserInfo(user);
            json.put("status", 200);
            json.put("message", "加入成功");
        }
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/quitgroup")
    public String quitGroup(HttpServletRequest req) {
        User user = ((User)req.getSession().getAttribute("user"));
        user.setGroupId(null);
        JSONObject json = new JSONObject();
        if (userService.quitGroup(user)) {
            json.put("status", 200);
            json.put("message", "成功退出当前组");
        } else {
            json.put("status", 400);
            json.put("message", "退出失败");
        }
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/deleteuser")
    public String deleteUser(Integer uid) {
        JSONObject json = new JSONObject();
        if (userService.deleteUser(uid)) {
            json.put("status", 200);
            json.put("message", "成功删除用户");
        } else {
            json.put("status", 400);
            json.put("message", "删除失败");
        }
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/modifyuserrole")
    public String modifyUserAndRole(UserWithRoleName u) {
        UserRole ur = new UserRole();
        ur.setRoleId(u.getRoleId());
        ur.setUserId(u.getUid());
        JSONObject json = new JSONObject();
        if (userRoleService.setRole(ur) && userService.modifyUserInfo(u)) {
            json.put("status", 200);
            json.put("message", "修改成功");
        } else {
            json.put("status", 200);
            json.put("message", "修改失败");
        }
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/createuserole")
    public String createUserRole(UserWithRoleName u) {
        UserRole ur = new UserRole();
        boolean b1 = userService.register(u);
        ur.setRoleId(u.getRoleId());
        ur.setUserId(u.getUid());
        boolean b2 = userRoleService.setRole(ur);
        JSONObject json = new JSONObject();
        if (b1 && b2) {
            json.put("status", 200);
            json.put("message", "添加成功");
        } else {
            json.put("status", 200);
            json.put("message", "添加失败");
        }
        return json.toJSONString();
    }
}
