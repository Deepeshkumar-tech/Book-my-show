package com.bookmyshow_mail.book_my_show_mail.controller;


import com.bookmyshow_mail.book_my_show_mail.requestBody.Threater;
import com.bookmyshow_mail.book_my_show_mail.service.ThreaterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail/threater")

public class ThreaterController
{
    @PostMapping("/create")
   public void sendThreaterRegistrationMail(@RequestBody Threater threater)
    {
        try
        {
            ThreaterService.sendThreaterRegistrationMail(threater);
            return new ResponseEntity("mail sent", HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity("mail failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hall/create")
    public void sendHallRegistrationMail(@RequestBody Hall hall)
    {
        try {
            threaterService.sendHallRegistrationMail(hall);
            throw new ResponseEntity("mail sent",HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







}
