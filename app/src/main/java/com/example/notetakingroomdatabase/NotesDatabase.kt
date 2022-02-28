package com.example.notetakingroomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.Instant

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase:RoomDatabase() {

    abstract fun getNoteDao():NotesDAO

    companion object{
        @Volatile
        private var INSTANCE:NotesDatabase? = null
        fun getDatabase(context: Context):NotesDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "note_database1").build()
                INSTANCE = instance
                instance
            }
        }
    }

}