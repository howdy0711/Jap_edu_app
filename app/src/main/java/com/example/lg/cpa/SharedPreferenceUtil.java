package com.example.lg.cpa;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 2016-06-06.
 */
public class SharedPreferenceUtil {
    public static final String APP_SHARED_PREFS = "thisApp.SharedPreference";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferenceUtil(Context context){
        this.sharedPreferences = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void setSharedId(String id){
        editor.putString("id",id);
        editor.commit();
    }
    public String getSharedId(){
        return sharedPreferences.getString("id","defValue");
    }
    public  void removeId(){
        editor.putString("id", "");
        editor.commit();
    }

    public void setSharedPass(String pass){
        editor.putString("password",pass);
        editor.commit();
    }
    public String getSharedPass(){
        return sharedPreferences.getString("pass","defValue");
    }
    public  void removePass(){
        editor.putString("pass", "");
        editor.commit();
    }

    public void setSharedNote(String note){
        editor.putString("note",note);
        editor.commit();
    }
    public String getSharedNote(){
        return sharedPreferences.getString("note","defValue");
    }
    public  void removeNote(){
        editor.putString("note", "");
        editor.commit();
    }

    public String getSharedClasses(){
        return sharedPreferences.getString("classes","defValue");
    }
    public  void removeClasses(){
        editor.putString("classes", "");
        editor.commit();
    }
    public void setSharedClasses(String note){
        editor.putString("classes",note);
        editor.commit();
    }

    public String getSharedWord(){
        return sharedPreferences.getString("word","defValue");
    }
    public  void removeWord(){
        editor.putString("word", "");
        editor.commit();
    }
    public void setSharedWord(String note){
        editor.putString("word",note);
        editor.commit();
    }

    public String getSharedKanzi(){
        return sharedPreferences.getString("kanzi","defValue");
    }
    public  void removeKanzi(){
        editor.putString("kanzi", "");
        editor.commit();
    }
    public void setSharedKanzi(String note){
        editor.putString("kanzi",note);
        editor.commit();
    }

    public String getSharedTime(){
        return sharedPreferences.getString("time","defValue");
    }
    public  void removeTime(){
        editor.putString("time", "");
        editor.commit();
    }
    public void setSharedTime(String note){
        editor.putString("time",note);
        editor.commit();
    }

    public String getSharedMean(){
        return sharedPreferences.getString("mean","defValue");
    }
    public  void removeMean(){
        editor.putString("mean", "");
        editor.commit();
    }
    public void setSharedMean(String note){
        editor.putString("mean",note);
        editor.commit();
    }

    public String getSharedLevel(){
        return sharedPreferences.getString("level","defValue");
    }
    public  void removeLevel(){
        editor.putString("level", "");
        editor.commit();
    }
    public void setSharedLevel(String note){
        editor.putString("level",note);
        editor.commit();
    }
    public String getSharedVersion(){
        return sharedPreferences.getString("version","defValue");
    }
    public  void removeVersion(){
        editor.putString("version", "");
        editor.commit();
    }
    public void setSharedVersion(String note){
        editor.putString("version",note);
        editor.commit();
    }
}
