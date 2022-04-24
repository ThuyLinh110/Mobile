package com.example.middledemo.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DogDao {
    @Query("SELECT * FROM DogBreed ORDER BY name")
    List<DogBreed> getAll();

    @Query("SELECT * FROM DogBreed WHERE name LIKE '%' || :name ")
    List<DogBreed> findByName(String name);

    @Query("SELECT * FROM DogBreed WHERE id = :id")
    DogBreed findById(int id);

    @Insert
    void insertAll(DogBreed... dogBreeds);

    @Delete
    void delete(DogBreed... dogBreed);
}
