package com.example.bestpracticevalidation.dto;

public class BaseStatus {
    private int status;
    private Boolean success;
    private String message;

    public BaseStatus() {
    }

    public BaseStatus(int status, Boolean success, String message) {
        this.status = status;
        this.success = success;
        this.message = message;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseStatus{" +
                "status=" + status +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
