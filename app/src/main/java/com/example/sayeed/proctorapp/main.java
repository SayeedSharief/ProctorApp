package com.example.sayeed.proctorapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by sayeed on 31/1/16.
 */
public class main extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this);

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }
}
