package com.example.notetakingroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table1")
data class Notes(@ColumnInfo(name = "note") val note: String){
    @PrimaryKey(autoGenerate = true) var id=0
}

