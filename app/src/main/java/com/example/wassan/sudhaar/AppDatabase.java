package com.example.wassan.sudhaar;

import android.arch.persistence.room.RoomDatabase;

/**
 * Created by wassan on 21/10/17.
 */

public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
