package com.example.posterapp.viewmodel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.posterapp.model.Poster;
import com.example.posterapp.model.PosterDao;

@Database(entities = {Poster.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PosterDao posterDao();
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "posterDB")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}