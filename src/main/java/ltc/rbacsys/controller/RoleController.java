package ltc.rbacsys.controller;


import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.bean.vo.RoleManageVO;
import ltc.rbacsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    @ResponseBody
    @RequestMapping("/deleterole")
    public String deleteRole(Integer rid) {
        JSONObject json = new JSONObject();
        if (roleService.deleteRole(rid)) {
            json.put("status", 200);
            json.put("message", "删除角色成功");
        } else {
            json.put("status", 400);
            json.put("message", "删除角色失败");
        }
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/modifyrole")
    public String modifyRole(@RequestBody RoleManageVO roleManageVO) {
        JSONObject json = new JSONObject();
        if (roleService.modifyRole(roleManageVO)) {
            json.put("status", 200);
            json.put("message", "修改角色成功");
        } else {
            json.put("status", 400);
            json.put("message", "修改角色失败");
        }
        System.out.println(json);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/createrole")
    public String createRole(@RequestBody RoleManageVO roleManageVO) {
        JSONObject json = new JSONObject();
        if (roleService.createRole(roleManageVO)) {
            json.put("status", 200);
            json.put("message", "新建角色成功");
        } else {
            json.put("status", 400);
            json.put("message", "新建角色失败");
        }
        return json.toJSONString();
    }

}
