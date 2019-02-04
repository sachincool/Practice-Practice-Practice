package com.crappy.architectureexample

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
                Toast.makeText(this@MainActivity,"HI",Toast.LENGTH_SHORT).show()
        })
    }
}
