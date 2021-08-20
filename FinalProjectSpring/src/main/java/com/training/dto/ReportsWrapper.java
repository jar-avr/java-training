package com.training.dto;

import com.training.entity.Report;
import com.training.entity.User;

import java.util.List;

public class ReportsWrapper {
    List<Report> reports;

    public ReportsWrapper(List<Report> reports) {
        this.reports = reports;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setUsers(List<Report> reports) {
        this.reports = reports;
    }
}
