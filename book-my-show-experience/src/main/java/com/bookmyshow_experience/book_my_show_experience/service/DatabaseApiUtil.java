package com.bookmyshow_experience.book_my_show_experience.service;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.Threater;
import com.bookmyshow_experience.book_my_show_experience.exception.DatabaseInsertionException;
import com.bookmyshow_experience.book_my_show_experience.requestbody.CreateUserRb;
import com.bookmyshow_experience.book_my_show_experience.requestbody.Hall;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Service
public class DatabaseApiUtil
{
    @Value ("${db.api.url}")
    String DbApiUrl;

    //calling Db api to save user
    public void createUser(CreateUserRb createUserRb)
    {
        String finalUrl=DbApiUrl+"/create";
        URI Url=URI.create(finalUrl);

        //create RequestEntity
       RequestEntity req=RequestEntity.post(Url).body(createUserRb);

       //create response entity and rest template
        RestTemplate restTemplate=new RestTemplate();

       ResponseEntity<String> response=restTemplate.exchange(Url, HttpMethod.POST,req, String.class);
       if (response.getStatusCode() != HttpStatus.CREATED)
       {
           throw new DatabaseInsertionException("Db api call failed");
       }
    }

    public void getUserById(UUID id)
    {
      String url=dbApiUrl +"/"+id.toString();
      URI finalUrl=URI.create(url);
      RequestEntity request=RequestEntity.get(url).build();

      RestTemplate restTemplate=new RestTemplate();
       try {
           ResponseEntity<AppUser> response = restTemplate.exchange(finalUrl, HttpMethod.GET, request, AppUser.class);

       }catch (Exception e)
       {
           throw e;
       }

       public void createThreater(threater )
      {

          String finalUrl=DbApiUrl+"/threater/create/";
          URI Url=URI.create(finalUrl);

          //create RequestEntity
          RequestEntity req=RequestEntity.post(Url).body(threater);

          //create response entity and rest template
          RestTemplate restTemplate=new RestTemplate();
           Try {
        ResponseEntity<Threater> response = restTemplate.exchange(Url, HttpMethod.POST, req, Threater.class);
        return response.getBody();
         } catch(Exception e)
        {
            throw e;
        }
          if (response.getStatusCode() != HttpStatus.CREATED)
          {
              throw new DatabaseInsertionException("Db api call failed");
          }
      }


       public Hall createHall(Hall hall)
        {   //create url
            String finalUrl=DbApiUrl+"/create/hall";
            URI Url=URI.create(finalUrl);

            //create RequestEntity
            RequestEntity request=RequestEntity.post(Url).body(hall);

            //hit the url
            RestTemplate restTemplate=new RestTemplate();
            try {
                ResponseEntity<Hall> response = restTemplate.exchange(finalUrl, HttpMethod.POST, request, Hall.class);
                return response.getBody();
            }catch (Exception e)
            {
                throw e;
            }
        }

    }

       public Threater getThreaterById(UUID threaterId)
       {
           //create url
           String finalUrl=DbApiUrl+"/{threaterId}";
           URI Url=URI.create(finalUrl);

           //create RequestEntity
           RequestEntity request=RequestEntity.post(Url).body();

           //hit the url
           RestTemplate restTemplate=new RestTemplate();
           try {
               ResponseEntity<Hall> response = restTemplate.exchange(finalUrl, HttpMethod.GET, request, Threater.class);
               return response.getBody();
           }catch (Exception e)
           {
               throw e;
           }
       }

       }


}
