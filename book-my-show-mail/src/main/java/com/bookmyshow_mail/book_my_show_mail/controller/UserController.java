package com.bookmyshow_mail.book_my_show_mail.controller;

import com.bookmyshow_mail.book_my_show_mail.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail/user")

public class UserController
{
    UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    @PostMapping ("/register")
   public ResponseEntity sendUserRegistrationMail(@RequestParam String email)
    try{

       userService.sendUserRegistrationMail(email);
        return new ResponseEntity(" mail sent successfully", HttpStatus.OK);
      }catch(Exception e)
    {
        return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
