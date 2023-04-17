package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParkingInfoReq {
    @JsonProperty("owner-name")
    private String ownerName;
    @JsonProperty("age")
    private int age;

    @Override
    public String toString() {
        return "ParkingInfoReq{" +
                "ownerName='" + ownerName + '\'' +
                ", age=" + age +
                ", carList=" + carList.toString()+
                '}';
    }

    @JsonProperty("car-list")
    private List<CarInfo> carList;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CarInfo> getCarList() {
        return carList;
    }

    public void setCarList(List<CarInfo> carList) {
        this.carList = carList;
    }
}
