package com.example.artistle.rv_firebase;


public class UserModel {
    String firstName, lastName, jod, age, key;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String jod, String age, String key) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jod = jod;
        this.age = age;
        this.key = key;
    }
}
