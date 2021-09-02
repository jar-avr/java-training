package ru.javavision.entity;

public enum ReportStatus {
    SUBMITTED,
    ACCEPTED,
    REJECTED;

    public String getType() {
        return name();
    }
}
