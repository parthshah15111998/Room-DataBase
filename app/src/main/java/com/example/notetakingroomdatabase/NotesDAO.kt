package com.example.notetakingroomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class NotesDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(notes: Notes)

    @Delete
    abstract suspend fun delete(notes: Notes)

    @Query("SELECT * FROM notes_table1 ORDER BY id ASC")
    abstract fun getAllNotes():LiveData<List<Notes>>
}