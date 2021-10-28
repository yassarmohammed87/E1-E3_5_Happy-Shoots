package com.example.lr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class appointmentdb extends SQLiteOpenHelper{


    public static final String DBNAME = "appointment.db";
    public appointmentdb(Context context) {
        super(context, "appointment.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table appointment(name TEXT primary key, phonenumber TEXT,email Text,time Text,date Text,location Text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists appointment");
    }
    public Boolean insertData(String name, String Phonenumber,String email,String time, String date, String location){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phonenumber", Phonenumber);
        contentValues.put("email", email);
        contentValues.put("time", time);
        contentValues.put("date",date);
        contentValues.put("location",location);
        long result = MyDB.insert("appointment", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
}