package com.example.bestpracticevalidation.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseError {
    int statusCode;
    String requestUrl;
    String code;
    String message;
    String resultCode;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<ErrorData> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ErrorData> errorList) {
        this.errorList = errorList;
    }

    List<ErrorData> errorList;

    @Override
    public String toString() {
        return "ResponseError{" +
                "statusCode='" + statusCode + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errorList=" + errorList +
                '}';
    }

    public ResponseError() {
    }

    public ResponseError(List<ErrorData> errorList) {
        this.message = "올바른 값이 아닙니다.";
        this.statusCode = HttpStatus.BAD_REQUEST.value();
        this.resultCode = "FAIL";
        this.errorList = errorList;
    }

}
