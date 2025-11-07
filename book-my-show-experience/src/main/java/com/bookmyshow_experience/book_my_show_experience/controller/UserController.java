package com.bookmyshow_experience.book_my_show_experience.controller;

import com.bookmyshow_experience.book_my_show_experience.exception.DatabaseInsertionException;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRb;
import com.bookmyshow_experience.book_my_show_experience.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/exp/register")
public class UserController
{
    @Autowired
    UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
   public ResponseEntity registerUser(@RequestBody CreateUserRb createUserRb)
    {
        try
        {
            userService.createUser(createUserRb);
            return new ResponseEntity("User created successfully",HttpStatus.CREATED);
        } catch (DatabaseInsertionException databaseInsertionException)
        {
            return  new ResponseEntity<>(databaseInsertionException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
