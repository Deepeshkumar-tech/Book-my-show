package com.bookmyshow_experience.book_my_show_experience.requestbody;

public class CreateThreaterRb
{
   String address;
   Long threaterHelpline;


    public CreateThreaterRb(String address) {

        this.address = address;
    }

    public CreateThreaterRb(Long threaterHelpline) {
        this.threaterHelpline = threaterHelpline;
    }


    public CreateThreaterRb() {
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Long getThreaterHelpline() {
        return threaterHelpline;
    }

    public void setThreaterHelpline(Long threaterHelpline) {
        this.threaterHelpline = threaterHelpline;
    }
}
