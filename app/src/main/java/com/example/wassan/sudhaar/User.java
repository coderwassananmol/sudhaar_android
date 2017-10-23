package com.example.wassan.sudhaar;
import android.arch.persistence.room.*;


/**
 * Created by wassan on 20/10/17.
 */

@Entity
public class User {

    @PrimaryKey
    private static int uid;

    @ColumnInfo(name = "first_name")
    private static String fName;

    @ColumnInfo(name = "last_name")
    private static String lName;
}