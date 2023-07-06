package com.d3lt4.bookstore.resources.exceptions;

public class StandardError {
    private Long timestamp;
    private Integer statusCode;
    private String messageError;

    public StandardError() {
        super();
    }

    public StandardError(Long timestamp, Integer statusCode, String messageError) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.messageError = messageError;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
}
