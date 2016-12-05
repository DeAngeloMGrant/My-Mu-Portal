package com.example.csstudent.monarch;

/**
 * Created by csstudent on 11/30/2016.
 */
public class Card {
    private String name;
    private String details;
    private int thumbnail;

    public Card(){
    }
    public Card(String name, String details, int thumbnail){
        this.name = name;
        this.details = details;
        this.thumbnail= thumbnail;
    }
    public String getName(){
        return name;
    }
    public void  setName(String name){
        this.name = name;
    }
    public String getDetails(){
        return details;
    }
    public void setDetails(String details){
        this.details = details;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
