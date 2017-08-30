package com.example.lg.cpa;

/**
 * Created by gom on 2016-06-02.
 */
public class Word {
    int id;
    String classes;
    String word;
    String kanzi;
    String times;
    String mean;
    String level;

    public Word(int id, String classes, String word
    ,String kanzi, String time, String mean, String level){
        this.id = id;
        this.classes = classes;
        this.word = word;
        this.kanzi = kanzi;
        this.times = time;
        this.mean = mean;
        this.level = level;
    }

    public int getID() {return this.id;}
    public String getClasses() {return this.classes;}
    public String getWord() {return this.word;}
    public String getKanzi() {return  this.kanzi;}
    public String getTime() {return this.times;}
    public String getMean() {return this.mean;}
    public String getLevel() {return this.level;}

}
