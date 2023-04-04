package com.example.project;

import android.content.Intent;

public class UserModel {
    private int id;
    private String mail;
    private String name;
    private String password;
    private String gender;
    private int weight,height;
    private String routine;

    public UserModel(int id, String mail, String name, String password, String gender, int weight, int height, String routine) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.routine = routine;
    }

    public UserModel() {

    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", gender='" + gender + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", routine='" + routine + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getRoutine() {
        return routine;
    }

    public void setRoutine(String routine) {
        this.routine = routine;
    }
}
