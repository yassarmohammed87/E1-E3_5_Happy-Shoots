package com.example.lr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class feedbackdb extends SQLiteOpenHelper{


    public static final String DBNAME = "Feedback.db";
    public feedbackdb(Context context) {
        super(context, "Feedback.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table feedback(username TEXT primary key, email TEXT,feedback Text,rating INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists feedback");
    }
    public Boolean insertData(String username, String email,String feedback,int rating){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("feedback", feedback);
        contentValues.put("rating", rating);
        long result = MyDB.insert("feedback", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
}
