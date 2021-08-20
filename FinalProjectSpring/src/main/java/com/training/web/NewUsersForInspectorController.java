package com.training.web;

import com.training.dto.UsersWrapper;
import com.training.services.ECodeService;
import com.training.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new-users")
public class NewUsersForInspectorController {
    @Autowired
    private UserService userService;

    @Autowired
    private ECodeService eCodeService;

    @ModelAttribute("users")
    public UsersWrapper usersWrapper() {
        return userService.findAllNewUsers();
    }

    @GetMapping
    public String showNewUsers(Model model) {
        model.addAttribute("eCodes", eCodeService.findAll());
        return "inspector/new-users";
    }

    @PostMapping
    public String updateNewUsers(@ModelAttribute("users") UsersWrapper users, BindingResult bindingResult) {
        userService.savePersonsWithECode(users.getUsers());
        return "redirect:/new-users";
    }
}
