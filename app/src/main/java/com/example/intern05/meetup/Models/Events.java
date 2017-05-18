package com.example.intern05.meetup.Models;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by intern05 on 15.05.2017.
 */

public class Events {

    String title;
    String eventDate;

    public Events(String title,String eventDate){
        this.title=title;
        this.eventDate=eventDate;
    }
    public Events(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }


}
