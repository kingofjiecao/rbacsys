package ltc.rbacsys.controller;

import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.bean.Permission;
import ltc.rbacsys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PermissionDisplayController {
    @Autowired
    PermissionService permissionService;
    @ResponseBody
    @RequestMapping("/getpermissions")
    public String getPermissions(){
        JSONObject json = new JSONObject();
        List<Permission> permissions = permissionService.getAllPermission();
        json.put("permissions", permissions);
        return json.toJSONString();
    }
}
