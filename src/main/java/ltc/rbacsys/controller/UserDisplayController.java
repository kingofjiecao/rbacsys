package ltc.rbacsys.controller;


import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.bean.Role;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.bean.dto.UserWithRoleName;
import ltc.rbacsys.service.RoleService;
import ltc.rbacsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserDisplayController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping("/getuserinfo")
    public String getUserInfo(HttpSession session) {
        User u = (User)session.getAttribute("user");
        JSONObject json = new JSONObject();
        json.put("user", u);
        return json.toJSONString();
    }
    @RequestMapping("/getuserinfowithrole")
    public String getUserInfoWithRole(HttpSession session) {
        User u = (User)session.getAttribute("user");
        UserWithRoleName userWithRoleName = userService.getUserWithRoleName(u);
        JSONObject json = new JSONObject();
        json.put("user", userWithRoleName);
        return json.toJSONString();
    }
    @RequestMapping("/getalluserinfo")
    public String getAllUserInfo() {
        List<User> users = userService.getAllUser();
        JSONObject json = new JSONObject();
        json.put("users", users);
        return json.toJSONString();
    }
    @RequestMapping("/ ")
    public String getUserAndRole(User user) {
        UserWithRoleName u = userService.getUserWithRoleName(user);
        List<Role> roles = roleService.getAllRoles();
        JSONObject json = new JSONObject();
        json.put("roles", roles);
        json.put("user", u);
        return json.toJSONString();
    }
}
