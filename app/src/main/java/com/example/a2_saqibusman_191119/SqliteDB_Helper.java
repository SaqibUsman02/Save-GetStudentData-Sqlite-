package com.example.a2_saqibusman_191119;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SqliteDB_Helper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "studentRecords.db";
    private static int DATABASE_VERSION = 1;
    private static String TABLE_NAME ="studentInfo";
    private Context MainContext;
   static String Query_Create="Create Table "+ TABLE_NAME + " ( std_id TEXT Primary Key,"+
           " std_Name TEXT, std_Age TEXT, std_City TEXT)";

    public SqliteDB_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        MainContext=context;
        Toast.makeText(context, "DataBase Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query_Create);
        Toast.makeText(MainContext, "Table Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean InsertStudentData(String s_id,String s_name, String s_city, String s_age)
    {
        SQLiteDatabase sql_db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Std_id",s_id);
        contentValues.put("Std_Name",s_name);
        contentValues.put("Std_City",s_city);
        contentValues.put("Std_Age",s_age);
        //Insert Function return -1 if not inserted data and return 0 if successfully inserted data
        //so here i save this result in varible InsertCheck
        long InsertCheck = sql_db.insert(TABLE_NAME,null,contentValues);
        if(InsertCheck==-1)
        {
            return false;
        }
        else {
            return true;
        }


    }

    public Cursor getStudentData()
    {
        SQLiteDatabase sql_db =this.getWritableDatabase();
        Cursor cursor = sql_db.rawQuery("select * from "+ TABLE_NAME,null);
        return cursor;
    }
}
