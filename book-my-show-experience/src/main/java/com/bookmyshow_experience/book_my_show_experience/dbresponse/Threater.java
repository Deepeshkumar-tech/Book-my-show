package com.bookmyshow_experience.book_my_show_experience.dbresponse;



import java.util.UUID;

public class Threater
{

    UUID id;
    AppUser owner;
    String address;
    Long threaterHelpline;


    public Threater() {
    }

    public Threater(UUID id) {
        this.id = id;
    }

    public Threater(AppUser owner) {
        this.owner = owner;
    }

    public Threater(String address) {
        this.address = address;
    }

    public Threater(Long threaterHelpline) {
        this.threaterHelpline = threaterHelpline;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
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
