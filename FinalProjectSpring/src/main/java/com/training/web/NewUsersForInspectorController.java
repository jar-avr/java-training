package com.training.web;

import com.training.dto.UsersWrapper;
import com.training.entity.User;
import com.training.services.ECodeService;
import com.training.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/new-users")
public class NewUsersForInspectorController {
    @Autowired
    private UserService userService;

    @Autowired
    private ECodeService eCodeService;

    @ModelAttribute("users")
    public UsersWrapper newUsersPage(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "5") int size,
                                     @RequestParam(defaultValue = "first_name") String sort_by,
                                     @RequestParam(defaultValue = "ASC") String sort_direction) {
        return userService.findAllNewUsers(page, size, sort_by, sort_direction);
    }

    @GetMapping
    public String showNewUsers(Model model) {
//        model.addAttribute("users", new UsersWrapper(userService.findAllNewUsers(page, size).getContent()));
        model.addAttribute("eCodes", eCodeService.findAll());
//        model.addAttribute("idAndECode", new PersonIdAndECodeDTO());
        return "inspector/new-users";
    }

    @PostMapping
    public String updateNewUsers(@ModelAttribute("users") UsersWrapper users,
                                 BindingResult bindingResult) {
        userService.savePersonsWithECode(users.getUserPage());
//        userService.updateECodeWherePersonId(idAndECode.getId(), idAndECode.getECode());
        return "redirect:/new-users";
    }
}
