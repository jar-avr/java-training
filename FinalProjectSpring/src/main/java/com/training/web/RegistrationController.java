package com.training.web;

import com.training.dto.InspectorRegistrationDto;
import com.training.dto.PersonRegistrationDto;
import com.training.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;


    @ModelAttribute("inspector")
    public InspectorRegistrationDto inspectorRegistrationDto() {
        return new InspectorRegistrationDto();
    }

    @ModelAttribute("person")
    public PersonRegistrationDto personRegistrationDto() {
        return new PersonRegistrationDto();
    }


    @GetMapping("/registration")
    public String showPersonRegistrationForm(Model model) {
        return "registration-form";
    }

    @GetMapping("/admin/registration")
    public String showInspectorRegistrationForm(Model model) {
        return "admin/registration-form";
    }

    @PostMapping("/registration")
    public String registerPersonAccount(@ModelAttribute("person") @Valid PersonRegistrationDto userDto,
                                           BindingResult result){

        if (result.hasErrors()) {
            return "registration-form";
        }

        try {
            userService.saveNewPerson(userDto);
        } catch (Exception e) {
            result.rejectValue("email", null, "There is already an account registered with that email");
            return "registration-form";
        }

        return "redirect:/registration?success";
    }

    @PostMapping("/admin/registration")
    public String registerInspectorAccount(@ModelAttribute("inspector") @Valid InspectorRegistrationDto userDto,
                                      BindingResult result){

        if (result.hasErrors()) {
            return "admin/registration-form";
        }

        try {
            userService.saveNewInspector(userDto);
        } catch (Exception e) {
            result.rejectValue("email", null, "There is already an account registered with that email");
            return "admin/registration-form";
        }

        return "redirect:/admin/registration?success";
    }
}
