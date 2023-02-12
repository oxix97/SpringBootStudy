package com.example.springbootvalidation.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    @NotBlank
    private String name;
    @Max(value = 90)
    private int age;
    @Email
    private String email;
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "핸드폰 번호가 아닙니다.")
    private String phoneNumber;

    @Size(min = 6, max = 6)
    private String reqYearMonth; // yyyyMM

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @AssertTrue(message = "yyyyMM형식이 아닙니다.")
    public boolean isCheckReqYearMonth() {
        String text = this.reqYearMonth + "01";
        try {
            LocalDate localDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }
}
