package com.hqsoft.esales.esales_trainee.bll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.hqsoft.esales.esales_trainee.model.AR_CUSTOMER;

import java.util.ArrayList;
import java.util.List;

public class AR_CustomerHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eSales1.db3";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_CUSTOMER = "AR_Customer";


    public AR_CustomerHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " +TABLE_NAME_CUSTOMER;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE AR_Customer(custID text primary key, name text, address text,phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void addCustomer(AR_CUSTOMER person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("custID",person.getCustID());
        contentValues.put("name",person.getName());
        contentValues.put("address",person.getAddress());
        contentValues.put("phone",person.getPhone());

        db.insert(TABLE_NAME_CUSTOMER,null,contentValues);
        db.close();
    }


    /*public List<AR_CUSTOMER> getAllCustomer(){
        List<AR_CUSTOMER> customerList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME_CUSTOMER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            AR_CUSTOMER customer = new AR_CUSTOMER(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
            customerList.add(customer);
            cursor.moveToNext();

        }
        return customerList;
    }*/

    public Cursor getAll(){
        String query = "SELECT * FROM AR_Customer" ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null ){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


}
