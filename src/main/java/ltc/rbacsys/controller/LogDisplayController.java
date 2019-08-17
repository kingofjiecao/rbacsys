package ltc.rbacsys.controller;


import com.alibaba.fastjson.JSONObject;
import ltc.rbacsys.bean.dto.LogWithUserName;
import ltc.rbacsys.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class LogDisplayController {
    @Autowired
    LogService logService;
    @ResponseBody
    @RequestMapping("/getalllog")
    public String showAllLog() {
        List<LogWithUserName> logs = logService.displayAllLog();
        JSONObject json = new JSONObject();
        json.put("logs", logs);
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/searchlog")
    public String searchLog(String type, HttpServletRequest req) throws UnsupportedEncodingException {
        String decodeType;
        decodeType = URLDecoder.decode(type, "UTF-8");
        List<LogWithUserName> logs = logService.searchByKeyWord("%" + decodeType + "%");
        JSONObject json = new JSONObject();
        json.put("logs", logs);
        System.out.println(json.toJSONString());
        return json.toJSONString();
    }
}
