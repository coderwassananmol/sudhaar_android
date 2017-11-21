package com.example.wassan.sudhaar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wassan on 24/10/17.
 */

public class SQLdatabase {
    /*private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Sudhaar";
    private static final String DATABASE_TABLE = "cases";
    private static final String TAG = "Query feed: ";
    private static String getPlace;
    private static String getCategory;
    private static String getSubcat;
    private static String getOfficer;
    private static String getService;
    private static String getCase;
    private static String getProof;
    private static String getAnonymous;
    private DatabaseReference mDatabase;


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
        db.close();
    }

    //Read from database
    public void onRead() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cases",null);
        int count = -1;
        if (cursor.moveToFirst()) {
            do {
                getCategory = cursor.getString(cursor.getColumnIndex(CATEGORY));
                getPlace = cursor.getString(cursor.getColumnIndex(PLACE));
                getSubcat = cursor.getString(cursor.getColumnIndex(SUBCAT));
                getOfficer = cursor.getString(cursor.getColumnIndex(OFFICER));
                getService = cursor.getString(cursor.getColumnIndex(SERVICE));
                //getCase = cursor.getString(cursor.getColumnIndex(CASE));
                getProof = cursor.getString(cursor.getColumnIndex(PROOF));
                getAnonymous = cursor.getString(cursor.getColumnIndex(ANONYMOUS));
                Log.i("Category: " , getCategory);
                Log.i("Place: " , getPlace);
                Log.i("Subcat: " , getSubcat);
                Log.i("Officer: " , getOfficer);
                Log.i("Service: " , getService);
                //Log.i("Case: " , getCase);
                Log.i("Proof: " , getProof);
                Log.i("Anonymous: " , getAnonymous);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    //Firebase
    public void firebase() {
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }*/
}