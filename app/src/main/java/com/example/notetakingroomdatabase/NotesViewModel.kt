package com.example.notetakingroomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) :AndroidViewModel(application) {

    val allNotes:LiveData<List<Notes>>
    private val repository:NotesRepository


    init {
        val dao=NotesDatabase.getDatabase(application).getNoteDao()
        repository = NotesRepository(dao)
        allNotes=repository.allNotes
    }

    fun insertNote(notes: Notes)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(notes)
    }

    fun deleteNote(notes: Notes)=viewModelScope.launch(Dispatchers.IO) {
        repository.delete(notes)
    }

}