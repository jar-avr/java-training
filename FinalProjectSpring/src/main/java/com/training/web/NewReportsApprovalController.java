package com.training.web;

import com.training.dto.ReportsWrapper;
import com.training.dto.UsersWrapper;
import com.training.entity.Report;
import com.training.services.ECodeService;
import com.training.services.ReportService;
import com.training.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewReportsApprovalController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/new-reports")
    public String showNewReports(Model model) {
        model.addAttribute("reports", reportService.findAllNewReports());
        return "inspector/new-reports";
    }

    @GetMapping("/new-reports/report-approval")
    public String showReportToApprove(@RequestParam(value = "id") Long id, Model model) {
        try {
            model.addAttribute("report", reportService.findById(id));
        } catch (Exception e) {
            return "inspector/new-reports";
        }
        return "inspector/report-approval";
    }

    @PostMapping(value = "/new-reports/report-approval", params = "accept")
    public String acceptReport(@ModelAttribute("report") Report report, Model model) {
        reportService.saveAccepted(report);
        return "inspector/new-reports";
    }

    @PostMapping(value = "/new-reports/report-approval", params = "reject")
    public String rejectReport(@ModelAttribute("report") Report report, Model model) {
        reportService.saveRejected(report);
        return "inspector/new-reports";
    }
}
