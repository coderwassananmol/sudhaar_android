package com.example.wassan.sudhaar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by wassan on 24/10/17.
 */

public class SQLdatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Sudhaar";
    private static final String DATABASE_TABLE = "cases";
    private static final String ID = "id";
    private static final String PLACE = "place";
    private static final String CATEGORY = "category";
    private static final String SUBCAT = "subcat";
    private static final String OFFICER = "officer";
    private static final String SERVICE = "service";
    private static final String CASE = "[Case]";
    private static final String PROOF = "proof";
    private static final String ANONYMOUS = "anonymous";
    private static final String TAG = "Query feed: ";

    public SQLdatabase(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + DATABASE_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PLACE + " STRING, " + CATEGORY + " STRING, " + SUBCAT + " STRING, " + OFFICER + " STRING, " + SERVICE + " STRING, " + CASE + " STRING, " + PROOF + " BOOLEAN, " + ANONYMOUS + " BOOLEAN );";
        db.execSQL(CREATE_TABLE);
    }

    //Updating Tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table
        String DROP_TABLE = "DROP TABLE IF EXISTS " + DATABASE_TABLE;
        onCreate(db);
    }

    //Inserting records
    public void onInsert(String place_name, String category, String subcat, String officer, String service, String Case, Boolean proof, Boolean anonymous) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLACE,place_name);
        contentValues.put(CATEGORY,category);
        contentValues.put(SUBCAT,subcat);
        contentValues.put(OFFICER,officer);
        contentValues.put(SERVICE,service);
        contentValues.put(CASE,Case);
        contentValues.put(PROOF,proof);
        contentValues.put(ANONYMOUS, anonymous);
        db.insert(DATABASE_TABLE,null,contentValues);
        Cursor cursor = db.rawQuery("SELECT category FROM cases",null);
        cursor.moveToFirst();
        Log.i(TAG,cursor.getString(0));
        db.close();
    }
}
