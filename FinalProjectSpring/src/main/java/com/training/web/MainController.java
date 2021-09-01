package com.training.web;

import com.training.entity.User;
import com.training.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @RequestMapping("/admin/admin-main")
    public String getAdminPage() {
        return "admin/admin-main";
    }

    @RequestMapping("/profile")
    public String getProfile(Model model, Authentication authentication) {
        model.addAttribute("user", userService.findByEmail(((User) authentication.getPrincipal()).getEmail()));
        return "person/profile";
    }
}
