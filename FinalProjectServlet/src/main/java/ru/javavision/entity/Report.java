package ru.javavision.entity;

import java.time.LocalDate;

public class Report {
    private Long id;
    private LocalDate date;
    private ReportType type;
    private ReportStatus status;
    private String comment;
    private Person person;

    public Report(Long id, LocalDate date, ReportType type, ReportStatus status, String comment, Person person) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.status = status;
        this.comment = comment;
        this.person = person;
    }

    public Report() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ReportType getType() {
        return type;
    }

    public void setType(ReportType type) {
        this.type = type;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
