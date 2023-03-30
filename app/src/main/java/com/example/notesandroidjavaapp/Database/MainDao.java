package com.example.notesandroidjavaapp.Database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notesandroidjavaapp.Models.Notes;

import java.util.List;

@Dao
public interface MainDao {

    @Insert (onConflict = REPLACE)
    void insert (Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE id = :id")
    void update (int id, String title, String notes);
}
