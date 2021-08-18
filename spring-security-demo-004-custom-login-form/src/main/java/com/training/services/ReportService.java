package com.training.services;

import com.training.entity.*;
import com.training.repository.PersonRepository;
import com.training.repository.ReportRepository;
import com.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final ReportRepository reportRepository;


    @Autowired
    public ReportService(UserRepository userRepository, PersonRepository personRepository, ReportRepository reportRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.reportRepository = reportRepository;
    }

    public Report saveNewReport(Report report, Person person) throws Exception {
//        if (userRepository.findById(report.getId()).isPresent()) {
//            throw new Exception ("There is already an account registered with email " + email);
//        }

        report.setStatus(ReportStatus.SUBMITTED);
        report.setPerson(person);
        return reportRepository.save(report);
    }

    public List<Report> findAllNewReports() {
        return reportRepository.findAllByStatus(ReportStatus.SUBMITTED);
    }

    @Transactional
    public void updateNewRecords(List<Report> reports) {
        reports.forEach(reportRepository::save);
    }

    public Report findById(Long id) throws Exception {
        return reportRepository.findById(id).orElseThrow(() ->
                new Exception("Report with id " + id + " was not found!"));
    }

    public void saveAccepted(Report report) {
        report.setStatus(ReportStatus.ACCEPTED);
        reportRepository.save(report);
    }

    public void saveRejected(Report report) {
        report.setStatus(ReportStatus.REJECTED);
        reportRepository.save(report);
    }
}
