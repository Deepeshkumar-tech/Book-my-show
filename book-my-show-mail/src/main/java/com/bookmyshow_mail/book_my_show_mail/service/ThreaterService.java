package com.bookmyshow_mail.book_my_show_mail.service;

import com.bookmyshow_mail.book_my_show_mail.utility.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreaterService
{
    @Autowired
    MailUtility mailUtility;
    public void sendThreaterResgistrationMail(Threater threater)throws Exception
    {
        String toEmail=threater.getOwner.getEmail;
        String address=threater.getAddress();
        String subjectLine="Theater registration successfull";
          mailUtility.sendUserRegistrationMail(Threater threater,toEmail,address,threater.getOwner.getName,subjectLine,);
    }


    public void sendHallRegistrationMail(Hall hall)throw Exception

    {
        String ownerEmail=hall.getThreater().getOwner().getEmail();
        String ownerName =hall.geThreater().getOwner().getName();
        String ownerLocation=hall.geThreater().getOwner().getAddress();
        int seats=hall.getSeats;
        String subjectLine="mail sent successfull";

        mailUtility.sendUserRegistrationMail(ownerEmail,ownerName,ownerLocation,seats,subjectLine);

    }

       //mail api:i am notify that hall is created in this thrater
       try{
        mailUtility.sendHallRegistrationMail(hall);

        }catch(Exception e)


}
