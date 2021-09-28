package com.hqsoft.esales.esales_trainee.bll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hqsoft.esales.esales_trainee.model.AR_SALESPERSON;


public class AR_SalespersonHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eSales1.db3";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_SALESPERSON = "AR_SalesPerson";


    public AR_SalespersonHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*private static final String SQL_CREATE_ENTRIES_AR_SALESPERSON =
            "CREATE TABLE " + AR_SalespersonHandler.TABLE_NAME_SALESPERSON + " (" +
                    "slsperID" + " TEXT PRIMARY KEY," +
                    "password" + " TEXT," +
                    "fullName" + " TEXT," +
                    "address" + " TEXT)";*/

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AR_SalespersonHandler.TABLE_NAME_SALESPERSON;

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE AR_SalesPerson(slsperID text primary key, password text, fullName text,address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }


    public boolean checkUser(String name,String password){

        SQLiteDatabase db = this.getWritableDatabase();

        //query to user table
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_SALESPERSON + " WHERE  fullName=? AND password=?",
                new String[]{name,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }


    public void addSalesPerson(AR_SALESPERSON person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("slsperID",person.getSlsperID());
        contentValues.put("password",person.getPassword());
        contentValues.put("fullName",person.getFullName());
        contentValues.put("address",person.getAddress());

        db.insert(TABLE_NAME_SALESPERSON,null,contentValues);
        db.close();
    }

}
