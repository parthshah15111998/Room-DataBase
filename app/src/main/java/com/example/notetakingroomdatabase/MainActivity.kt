package com.example.notetakingroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), IAdapter {

    private lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=NotesAdapter(this)
        recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this).get(NotesViewModel::class.java)

        viewModel.allNotes.observe(this) {
            adapter.updateData(it)
        }
    }

    fun addNote(view: View) {
        val intent = Intent(this,AddNoteActivity::class.java)
        startActivity(intent)
    }

    override fun onNoteClick(notes: Notes) {
        viewModel.deleteNote(notes)
    }
}