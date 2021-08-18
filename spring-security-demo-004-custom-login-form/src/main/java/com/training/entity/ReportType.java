package com.training.entity;

public enum ReportType {
    SINGLE_TAX,
    VAT_DECLARATION;

    public String getType() {
        return name();
    }
}
