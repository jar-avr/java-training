package com.training.web;

import com.training.dto.InspectorRegistrationDto;
import com.training.dto.PersonRegistrationDto;
import com.training.entity.Report;
import com.training.entity.User;
import com.training.services.ReportService;
import com.training.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/submit-report")
public class ReportSubmissionController {

    @Autowired
    private ReportService reportService;


    @ModelAttribute("report")
    public Report report() {
        return new Report();
    }

    @GetMapping
    public String showReportSubmissionForm(Model model) {
        return "person/report";
    }

    @PostMapping
    public String submitReport(@ModelAttribute("report") Report report,
                               BindingResult result){

        if (result.hasErrors()) {
            return "person/report";
        }

        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            reportService.saveNewReport(report, user.getPerson());
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            result.rejectValue("email", null, "There is already an account registered with that email");
            return "person/report";
        }

        return "redirect:/submit-report?success";
    }
}
