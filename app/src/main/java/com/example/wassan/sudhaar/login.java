package com.example.wassan.sudhaar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wassan on 20/11/17.
 */

public class login extends SQLiteOpenHelper {

    public login(Context context) {
        super(context,"users",null,1);
    }
    public void onCreate(SQLiteDatabase database) {
        String tableQuery = "CREATE TABLE Users ( id integer(2) PRIMARY KEY, username varchar(20) UNIQUE, password varchar(50))";
        database.execSQL(tableQuery);
    }

    public void onUpgrade(SQLiteDatabase database, int i, int ii) {
        String upgradeQuery = "DROP TABLE IF EXISTS Users";
        onCreate(database);
    }

    public void addData() throws NoSuchAlgorithmException {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username","ANMOL");
        String password = "jan261998";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        String hex = String.format( "%064x", new BigInteger( 1, digest ) );
        contentValues.put("password",digest);
        database.insert("Users",null,contentValues);
        database.close();
    }

    public void readData() {
        SQLiteDatabase database = this.getReadableDatabase();
        String[] columns = {"hex(password)"};
        Cursor cursor;
        cursor = database.query("Users",columns,"username = ?",new String[] {"ANMOL"},null,null,null);
        Log.i("Count: " , "Count: "+cursor.getCount());
        cursor.moveToFirst();
        Log.i("Password",cursor.getString(0));
        cursor.close();
    }
}
