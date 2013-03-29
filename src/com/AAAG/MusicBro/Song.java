package com.AAAG.MusicBro;

public class Song {
    public String name;
    public String path;
    public String album;
    public String genre;
    public String artist;
    public int count;
    public int rating;

    public void incrementCount(){
        this.count++;
    }

    public void rate(int value){
        this.rating = value;
    }

}
