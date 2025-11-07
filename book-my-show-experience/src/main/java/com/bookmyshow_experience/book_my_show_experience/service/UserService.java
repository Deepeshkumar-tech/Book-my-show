package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRb;
import com.bookmyshow_experience.book_my_show_experience.util.MailApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{   @Autowired
   DatabaseApiUtil databaseApiUtil;
    MailApiUtil mailApiUtil;
    CreateUserRb createUserRb;
    @Autowired
    public UserService(DatabaseApiUtil databaseApiUtil, MailApiUtil mailApiUtil) {
        this.databaseApiUtil = databaseApiUtil;
        this.mailApiUtil=mailApiUtil;
    }

    public void createUser(CreateUserRb createUserRb)

     try
    {
        databaseApiUtil.createUser( createUserRb);
    }catch(Exception e)
    {
        throw e;
    }
   try
    {
        mailApiUtil.sendUserRegistrationMail(createUserRb.getEmail(), createUserRb.getName());
    }catch(Exception e)
    {
        System.out.println(e.getMessage());
    }




}
