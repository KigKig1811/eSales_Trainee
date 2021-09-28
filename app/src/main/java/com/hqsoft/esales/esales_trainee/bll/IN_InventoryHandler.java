package com.hqsoft.esales.esales_trainee.bll;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class IN_InventoryHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eSales1.db3";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME= "IN_Inventory";

    private static final String SQL_CREATE_ENTRIES =
            " CREATE TABLE " + IN_InventoryHandler.TABLE_NAME + "(" +
                    "initID" + "TEXT Primary key," +
                    "name"   + " TEXT," +
                    "unit"   + "TEXT,"+
                    "price"  + "TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + IN_InventoryHandler.TABLE_NAME;

    public IN_InventoryHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
