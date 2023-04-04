package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_MAIL = "USER_MAIL";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_GENDER = "USER_GENDER";
    public static final String COLUMN_USER_WEIGHT = "USER_WEIGHT";
    public static final String COLUMN_USER_HEIGHT = "USER_HEIGHT";
    public static final String COLUMN_USER_ROUTINE = "USER_ROUTINE";

    public DataBase(@Nullable Context context) {
        super(context,"user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + USER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_MAIL + " TEXT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_GENDER + " TEXT, " + COLUMN_USER_WEIGHT + " INT, " + COLUMN_USER_HEIGHT + " INT, " + COLUMN_USER_ROUTINE + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addOne(UserModel userModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();

        cv.put(COLUMN_USER_MAIL,userModel.getMail());
        cv.put(COLUMN_USER_NAME,userModel.getName());
        cv.put(COLUMN_USER_PASSWORD,userModel.getPassword());
        cv.put(COLUMN_USER_GENDER,userModel.getGender());
        cv.put(COLUMN_USER_WEIGHT,userModel.getWeight());
        cv.put(COLUMN_USER_HEIGHT,userModel.getHeight());
        cv.put(COLUMN_USER_ROUTINE,userModel.getRoutine());

        long insert = db.insert(USER_TABLE, null, cv);
        if(insert==-1){
            return false;
        }
        return true;
    }
    public boolean checkName(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =  db.rawQuery("Select * from USER_TABLE where USER_NAME=?",new String[]{name});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkNamePassword(String name,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =  db.rawQuery("Select * from USER_TABLE where USER_NAME = ? and USER_PASSWORD = ?",new String[]{name,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public  List<UserModel> information(String name){
        SQLiteDatabase db=this.getReadableDatabase();
        List<UserModel> returnList=new ArrayList<>();
        Cursor cursor =  db.rawQuery("Select * from USER_TABLE where USER_NAME = ? ",new String[]{name});
        if(cursor!=null){
            if(cursor.moveToFirst()) {
                int id = cursor.getInt(0);
                String email = cursor.getString(1);
                String username = cursor.getString(2);
                String password = cursor.getString(3);
                String usergender = cursor.getString(4);
                int weight = cursor.getInt(5);
                int height = cursor.getInt(6);
                String routine = cursor.getString(7);
                UserModel newUser = new UserModel(id, email, username, password, usergender, weight, height, routine);
                returnList.add(newUser);
            }
        }
        return returnList;
    }
}
