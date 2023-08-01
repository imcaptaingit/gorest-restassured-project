package com.gorest.model;

public class UserPojo {

    private String name;
    private String email;
    private String gender;

    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender(String gender) {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus(String status) {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
}
