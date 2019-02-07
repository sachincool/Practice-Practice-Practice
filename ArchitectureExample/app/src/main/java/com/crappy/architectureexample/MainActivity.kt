package com.crappy.architectureexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  noteViewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
                val adapter=NoteAdapter()
        recycler_view.adapter=adapter

        noteViewModel = ViewModelProviders.of(this,NoteViewModelFactory(application)).get(NoteViewModel::class.java)
        noteViewModel.getAllNotes().observe(this, Observer {
                adapter.setNotes(it)
            adapter.notifyDataSetChanged()

        })
        btn_add_notes.setOnClickListener {
           val intent= Intent(this,AddNote::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== 1 && resultCode == Activity.RESULT_OK){
           val note= Note(1,data!!.getStringExtra("title"),
                    data.getStringExtra("description"),
            data.getIntExtra("numberpicker",1))
            noteViewModel.insert(note)
            Toast.makeText(this,"SAved",Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this,"Note Not Saved",Toast.LENGTH_SHORT).show()   }
}
