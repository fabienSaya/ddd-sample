package com.bnp.lafabrique.ddd.presentation.config;

public class ErrorDetail {
    private String title;
    private String message;
    private int errorCode;
    public ErrorDetail(String title, String message, int errorCode) {
        this.title = title;
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
