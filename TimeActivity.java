package com.example.yooyj.hw2;

/**
 * Created by yooyj on 2016-04-11.
 */
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Date;

/*
Homework #1
Author : Yoo Young Joon
Date : 2016/03/27
This project is my Time table. If it is today's schedules, the day's line is colorful.
And if you rotate this display, the display is changed.
* */
public class TimeActivity extends AppCompatActivity {

    private LinearLayout Mon;
    private LinearLayout Tue;
    private LinearLayout Wed;
    private LinearLayout Thurs;
    private LinearLayout Fri;
    @Override
    //Declare variable in onCreate function
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);

        Mon =(LinearLayout)findViewById(R.id.Mon);
        Tue =(LinearLayout)findViewById(R.id.Tues);
        Wed =(LinearLayout)findViewById(R.id.Wed);
        Thurs =(LinearLayout)findViewById(R.id.Thur);
        Fri =(LinearLayout)findViewById(R.id.Fri);
    }
    //If you rotate display or the activity is died,
    //continue to be colorful

    protected void onResume()
    {
        String tmp;
        super.onResume();
        current();
    }

    //If the date is passed, so tomorrow, Automatically change the date line's color.
    protected void onStop()
    {
        super.onStop();
        setWhite();
    }

    // This method is to change color if today is passed.
    // Setting white the date's line
    private void setWhite()
    {
        Date date= new Date();
        String a =date.toString();
        int space;
        space=a.indexOf(" ");

        if(a.substring(0,space).equalsIgnoreCase("Mon")) {
            Mon.setBackgroundColor(Color.WHITE);
        }
        else if(a.substring(0,space).equalsIgnoreCase("Tue"))
        {
            Tue.setBackgroundColor(Color.WHITE);
        }
        else if(a.substring(0,space).equalsIgnoreCase("Wed"))
        {
            Wed.setBackgroundColor(Color.WHITE);
        }
        else if(a.substring(0,space).equalsIgnoreCase("Thu"))
        {
            Thurs.setBackgroundColor(Color.WHITE);
        }
        else if(a.substring(0,space).equalsIgnoreCase("Fri"))
        {
            Fri.setBackgroundColor(Color.WHITE);
        }
    }

    // This method is to change color if today is collect.
    // Setting color the date's line & Toast message : What day is today.
    private void current()
    {
        Date date= new Date();
        String a =date.toString();
        int space;
        space=a.indexOf(" ");

        if(a.substring(0,space).equalsIgnoreCase("Mon")) {
            Mon.setBackgroundColor(Color.CYAN);
            Toast.makeText(getApplicationContext(),"오늘은 월요일",Toast.LENGTH_SHORT).show();
        }
        else if(a.substring(0,space).equalsIgnoreCase("Tue"))
        {
            Tue.setBackgroundColor(Color.CYAN);
            Toast.makeText(getApplicationContext(),"오늘은 화요일",Toast.LENGTH_SHORT).show();
        }
        else if(a.substring(0,space).equalsIgnoreCase("Wed"))
        {
            Wed.setBackgroundColor(Color.CYAN);
            Toast.makeText(getApplicationContext(),"오늘은 수요일",Toast.LENGTH_SHORT).show();
        }
        else if(a.substring(0,space).equalsIgnoreCase("Thu"))
        {
            Thurs.setBackgroundColor(Color.CYAN);
            Toast.makeText(getApplicationContext(),"오늘은 목요일",Toast.LENGTH_SHORT).show();
        }
        else if(a.substring(0,space).equalsIgnoreCase("Fri"))
        {
            Fri.setBackgroundColor(Color.CYAN);
            Toast.makeText(getApplicationContext(),"오늘은 금요일",Toast.LENGTH_SHORT).show();
        }
    }
}