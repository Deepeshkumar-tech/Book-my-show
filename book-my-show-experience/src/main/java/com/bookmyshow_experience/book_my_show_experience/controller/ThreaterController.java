package com.bookmyshow_experience.book_my_show_experience.controller;

import com.bookmyshow_experience.book_my_show_experience.exception.InvalidUser;
import com.bookmyshow_experience.book_my_show_experience.exception.ThreaterNotFound;
import com.bookmyshow_experience.book_my_show_experience.exception.Unauthorised;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateThreaterRb;
import com.bookmyshow_experience.book_my_show_experience.requestbody.Hall;
import com.bookmyshow_experience.book_my_show_experience.service.ThreaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/exp/threater")
public class ThreaterController
{
    @Autowired
    CreateThreaterRb createThreaterRb;
    @Autowired
    ThreaterService threaterService
    @PostMapping("/Create")
    public ResponseEntity createThreater(@RequestBody CreateThreaterRb createThreaterRb, @RequestParam UUID ownerUserId)
   try

    {
        threaterService.createThreater(createThreaterRb,ownerUserId);
        return new ResponseEntity(threater, HttpStatus.CREATED);
    }catch(Exception e)
    {
        return new ResponseEntity()
    }


   @PostMapping("/hall/create")
   {
       public void createHall(@RequestParam UUID  ownerID,@RequestParam ThreaterID,@RequestParam hallSeats)

      {
          //call service layer
          try {
             Hall hall=threaterService.createHallForThreater(ownerID, ThreaterID, hallSeats);
             return ResponseEntity(hall,HttpStatus.CREATED);
          } catch (InvalidUser e) {
              return ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
          }catch (Unauthorised e){
              return ResponseEntity(e.getMessage(),HttpStatus.UNAUTHORIZED);
          }catch (ThreaterNotFound){
              return ResponseEntity(e.getMessage(),HttpStatus.UNAUTHORIZED);
          } catch (Exception e) {
              return ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

          }


      }
   }

}

