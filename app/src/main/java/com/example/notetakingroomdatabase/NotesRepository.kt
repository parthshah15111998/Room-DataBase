package com.example.notetakingroomdatabase

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDAO: NotesDAO) {

    val allNotes=notesDAO.getAllNotes()

     suspend fun insert(note: Notes){
         notesDAO.insert(note)
     }

    suspend fun delete(note: Notes){
        notesDAO.delete(note)
    }
}