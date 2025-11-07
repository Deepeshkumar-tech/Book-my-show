package com.bookmyshow_mail.book_my_show_mail.requestBody;



import java.util.UUID;

public class Hall
{

        UUID id;
        Threater threater;
        int  seats;


        public Hall(UUID id) {
            this.id = id;
        }

        public Hall(Threater threater) {
            this.threater = threater;
        }

        public Hall(int seats) {
            this.seats = seats;
        }

        public Hall() {
        }


        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }


        public Threater getThreater() {
            return threater;
        }

        public void setThreater(Threater threater) {
            this.threater = threater;
        }


        public int getSeats() {
            return seats;
        }

        public void setSeats(int seats) {
            this.seats = seats;
        }
    }

}
