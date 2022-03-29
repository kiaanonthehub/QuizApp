package com.kiaan.quizapp;

public class User {

    // class variables
    private String firstName;
    private String lastName;
    private String course;
    private String module;
    private String phoneNumber;
    private String role;

    // constructor
    public User(String firstName, String lastName, String course, String module, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.module = module;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
