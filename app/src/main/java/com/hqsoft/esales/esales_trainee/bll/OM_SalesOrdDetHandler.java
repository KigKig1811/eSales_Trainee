package com.hqsoft.esales.esales_trainee.bll;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OM_SalesOrdDetHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eSales1.db3";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "OM_SalesOrdDet";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    "orderNbr" + "TEXT Primary key," +
                    "lineRef" + "TEXT ," +
                    "invtID" + "TEXT ," +
                    "lineAmt" + "REAL ," +
                    "lineQty" + "REAL)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public OM_SalesOrdDetHandler( Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
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
