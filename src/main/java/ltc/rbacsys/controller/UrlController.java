package ltc.rbacsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {
    @RequestMapping("/")
    public String index(){
        return "/login.html";
    }
}
