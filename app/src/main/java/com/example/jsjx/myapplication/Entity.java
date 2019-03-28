package com.example.jsjx.myapplication;

public class Entity {
    private String title;
    private  int picture;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public Entity(String title, int picture) {

        this.title = title;
        this.picture = picture;
    }
}
