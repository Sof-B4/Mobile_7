package com.example.mobiles4.Data.DataSources.Room.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "items")
public class Item2 {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "image_resource")
    private int imageResource;

    @ColumnInfo(name = "text")
    private String text;

    public Item2(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    // Геттеры и сеттеры
    public void setText(String text) {
        this.text = text;
    }
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
    public String getText() {
        return text;
    }
    public int getImageResource() {
        return imageResource;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

}

