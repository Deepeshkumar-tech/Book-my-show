package com.bookmyshow_mail.book_my_show_mail.requestBody;

import jakarta.persistence.Column;

import java.util.UUID;

public class AppUser
{
    UUID id;
    String name;

    String email;

    String password;

    Long contactNumber;
    String userType;

    //creating constructor

    public AppUser(UUID id) {
        this.id = id;
    }

    public AppUser(String name) {
        this.name = name;
    }

    public AppUser(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    //creating getter and setter


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


}
