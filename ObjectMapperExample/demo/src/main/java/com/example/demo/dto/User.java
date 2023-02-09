package com.example.demo.dto;

public class User {
    private String name;
    private int age;

    public User() {
    }


    // obejct mapper를 이용하는 경우 getter를 사용하기 때문에 메서드 첫 네임 으로  get를 붙이면 안된다.
    // 실행하게 되면 get -> get -> ... 무한 반복이 일어나며 StackOverflowError가 나오게 된다.

//    public User getUser() {
//        return new User("user", 1);
//    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
