package com.crappy.architectureexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

/**
 * Created by crappy on 5/2/19.
 */
class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var items= emptyList<Note>()


    fun setNotes(notes:List<Note>){
        items=notes
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NoteViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(v)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = items!![position]
        holder.set(item)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun set(item: Note) {
            itemView.text_view_title.text=item.title
            itemView.textview_description.text=item.description
            itemView.text_view_priority.text= item.priority.toString()
        }
    }
}