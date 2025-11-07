package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateThreaterRb;
import org.springframework.stereotype.Service;

@Service
public class EntityMapper
{
    public void convertCreateThreaterRbToModelThreater(CreateThreaterRb createThreaterRb, AppUser appUser)
    {
        Threater threater=new Threater();
        threater.setOwner(owner);
        threater.setAddress(createThreaterRb.getAddress());
        threater.getThreaterHelpline(createThreaterRb.getThreaterHelpline());
    }

}
