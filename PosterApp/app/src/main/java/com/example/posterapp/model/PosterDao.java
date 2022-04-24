package com.example.posterapp.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PosterDao {
    @Query("SELECT * FROM poster ORDER BY name")
    List<Poster> getAll();

    @Query("SELECT * FROM poster WHERE name LIKE  :name ")
    List<Poster> findByName(String name);



    @Insert
    void insertAll(Poster... dogBreeds);

    @Delete
     void delete(Poster... dogBreed) ;

//    @Query("DELETE FROM poster WHERE id = :id")
//    void deleteById(int id);

    @Update
    void update(Poster... poster);

}
