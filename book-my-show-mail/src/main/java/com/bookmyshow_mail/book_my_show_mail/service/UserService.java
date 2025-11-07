package com.bookmyshow_mail.book_my_show_mail.service;

import com.bookmyshow_mail.book_my_show_mail.utility.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService
{
    MailUtility mailUtility;

    @Autowired
    public UserService(MailUtility mailUtility)
    {
        this.mailUtility = mailUtility;
    }


    public void sendUserRegistrationMail( String email)throws Exception
    {
        mailUtility.sendMail("welcome to my book my show!!");
    }





}
