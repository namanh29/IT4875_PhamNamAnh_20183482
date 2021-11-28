package com.example.gmail;

import android.graphics.Color;

import java.util.Random;

public class ItemModel {
    private int avatarResource;
    private String name;
    private String title;
    private String content;
    private String time;
    private boolean selected;

    public ItemModel(String name, String title, String content, String time) {
        Random rnd = new Random();
        this.avatarResource = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        this.name = name;
        this.title = title;
        this.content = content;
        this.time = time;
        this.selected = false;
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    public void setAvatarResource(int avatarResource) {
        this.avatarResource = avatarResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}


