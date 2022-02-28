package com.example.notetakingroomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var listener:IAdapter):RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private val allNotes=ArrayList<Notes>()

    class NotesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textView:TextView=itemView.findViewById(R.id.tv_text)
        val deleteButton:ImageView=itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder=NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener {
            listener.onNoteClick(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentItem=allNotes[position]
        holder.textView.text=currentItem.note
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateData(newData:List<Notes>){
        allNotes.clear()
        allNotes.addAll(newData)
        notifyDataSetChanged()
    }

}

interface IAdapter{
    fun onNoteClick(notes: Notes)
}