package com.hqsoft.esales.esales_trainee.bll;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class OM_SalesOrdHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eSales1.db3";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "OM_SalesOrder";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + OM_SalesOrdHandler.TABLE_NAME + "(" +
                    "orderNbr" + "TEXT Primary key ,"+
                    "slsperID" + "TEXT,"+
                    "custID" + "TEXT,"+
                    "orderAmt" + "REAL,"+
                    "orderQty" + "REAL," +
                    "orderDate" + "DATETIME," +
                    "remark" + "TEXT )";

    private static final String SQL_DETELE_ENTRIES =
            "DROP TABLE IF EXISTS " + OM_SalesOrdHandler.TABLE_NAME;

    public OM_SalesOrdHandler( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DETELE_ENTRIES);
        onCreate(db);
    }
}
