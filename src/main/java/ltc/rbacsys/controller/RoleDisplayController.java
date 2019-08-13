package ltc.rbacsys.controller;

import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.bean.Permission;
import ltc.rbacsys.bean.Role;
import ltc.rbacsys.service.PermissionService;
import ltc.rbacsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleDisplayController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @ResponseBody
    @RequestMapping("/getrole")
    public String getAllRole() {
        List<Role> roles = roleService.getAllRoles();
        JSONObject json = new JSONObject();
        json.put("roles", roles);
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getrolewithpermission")
    public String getRoleWithPermission(Integer rid) {
        List<Permission> permissions = permissionService.getPermissionsByRid(rid);
        Role role = roleService.getRoleByRid(rid);
        JSONObject json = new JSONObject();
        json.put("permissions", permissions);
        json.put("role", role);
        return json.toJSONString();
    }
}
