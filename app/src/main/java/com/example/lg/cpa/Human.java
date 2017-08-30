package com.example.lg.cpa;

import android.graphics.Bitmap;

public class Human {
    public String name;
    public String gender;
    public String age;
    public Bitmap image;

    Human(String name, String gender, String age, Bitmap image){
        this.image = image;
        this.name =name;
        this.gender = gender;
        this.age = age;
    }
}
