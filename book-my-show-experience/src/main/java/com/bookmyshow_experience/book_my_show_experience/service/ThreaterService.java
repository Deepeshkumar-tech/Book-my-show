package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.enums.UserType;
import com.bookmyshow_experience.book_my_show_experience.exception.InvalidUser;
import com.bookmyshow_experience.book_my_show_experience.exception.ThreaterNotFound;
import com.bookmyshow_experience.book_my_show_experience.exception.Unauthorised;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateThreaterRb;
import com.bookmyshow_experience.book_my_show_experience.requestbody.Hall;
import com.bookmyshow_experience.book_my_show_experience.util.MailApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThreaterService
{
    DatabaseApiUtil databaseApiUtil;
    @Autowired
    EntityMapper entityMapper;
    @Autowired
    MailApiUtil mailApiUtil;
    public Threater createThreater(CreateThreaterRb createThreaterRb, UUID ownerUserId)
    {
        //is userId exist in system or not
        //if exists then check type of customer
        //call DB api to

        AppUser user=databaseApiUtil.getUserById(ownerUserId);

        if(!user.getUserType().equals("ThreaterOwner"))
        {
            //exception throw
            throw  new InvalidUser(String.format("user with  id is %s doesnot have access to create threater") );

        }


        //if you dont come inside if condition that means user is threater owner
        Threater threater=entityMapper.convertCreateThreaterRbToModelThreater(createThreaterRb,user);
       Threater responseThreater=databaseApiUtil.createTreater(Threater);

       //call mail api to notify owner that threater got registered

         mailApiUtil.sendTheaterRegistrationMail(threater);

         return responseThreater;
    }

     public hall createHallForThreater(UUID threaterId,UUID ownerID,int hallSeats)
     {
        //verify user exist in system or not
         //if user exist then check type of user
        AppUser user=databaseApiUtil.getUserById(ownerID);

        if (user==null)
        {
            throw new InvalidUser(String.format("user id  is with id %s in not exist in system",ownerID.toString()))
        }

        if(!user.getUserType().equals(UserType.ThreaterOwner))
        {
            throw new Unauthorised(String.format("user with id %s does not have access to create halla",))
        }

        //call database api to create hall in database
         //To create hall objects we need 2 things hallSeats and threater ojects
         //Experience api has ThreaterID
         //we need to develop getThreaterById in database to get threater
         Hall hall=new Hall();
        try {

           Threater threater=databaseApiUtil.getThreaterById(threaterId);
           if (threater==null)
           {
               throw new ThreaterNotFound(String.format("threater with id %s is not exist in system",threaterId.toString()));
           }
           if(!threater.getOwner().getId().equals(ownerID))
           {
               throw new Unauthorised(String.format(" User with id %s does not access to create hall"));

           }

            hall.setThreater(threater);
            hall.setSeats(hallSeats);
            Hall hall = databaseApiUtil.createHall(hall);
        } catch (Exception e) {
            throw e;
        }


        return hall;
        //Mail Api ;this created for sending mail to owner that hall  is created for the threater




     }
}
