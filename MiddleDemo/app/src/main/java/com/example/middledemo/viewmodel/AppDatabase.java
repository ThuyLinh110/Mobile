package com.example.middledemo.viewmodel;

import android.content.Context;

import androidx.room.*;

import com.example.middledemo.model.DogBreed;
import com.example.middledemo.model.DogDao;

@Database(entities = {DogBreed.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DogDao dogDao();
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "dogDB")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
