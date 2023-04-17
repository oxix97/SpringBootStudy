package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarInfo {
    @JsonProperty("name")
    private String carName;
    @JsonProperty("number")
    private String carNumber;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String name) {
        this.carName = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "carName='" + carName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
