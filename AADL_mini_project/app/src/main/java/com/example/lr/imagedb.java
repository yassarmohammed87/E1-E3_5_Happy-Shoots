package com.example.lr;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class imagedb extends SQLiteOpenHelper {
    public static final String DBNAME = "imagedb";
    public imagedb(Context context) {
        super(context, "image.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase Imagedb) {
        Imagedb.execSQL("create Table image(imagepath TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertData(String path) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("path",path);
        long result = MyDB.insert("images", null, contentValues);
        if(result==-1) return false;
        else
            return true;

    }
}
