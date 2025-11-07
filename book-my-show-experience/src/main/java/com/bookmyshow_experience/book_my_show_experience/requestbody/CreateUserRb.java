package com.bookmyshow_experience.book_my_show_experience.requestbody;

import jakarta.persistence.Column;

public class CreateUserRb
{
    String name;
    String email;
    String password;
    Long contactNumber;
    String userType;


    //create all arg constructor


    public CreateUserRb(String name)
    {
        this.name = name;
    }

    public CreateUserRb(Long contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    //no argument constructor

    public CreateUserRb()
    {
    }

    //creating getter and setter


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
