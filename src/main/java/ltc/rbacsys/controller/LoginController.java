package ltc.rbacsys.controller;


import ltc.rbacsys.bean.User;
import ltc.rbacsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User u = userService.login(user);
        if (u != null) {
            session.setAttribute("user", u);
            return "redirect:/user/userinfo.html";
        } else {
            return "redirect:/login.html";
        }
    }

    @RequestMapping("/register")
    public String register(User user) {
        if (userService.register(user)) {
            return "redirect:/login.html";
        } else {
            return "redirect:/register.html";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login.html";
    }

}
