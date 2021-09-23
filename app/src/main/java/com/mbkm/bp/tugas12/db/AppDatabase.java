package com.mbkm.bp.tugas12.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
