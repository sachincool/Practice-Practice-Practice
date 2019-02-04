package com.crappy.architectureexample

import android.app.Application
import android.os.AsyncTask
import android.os.Handler
import androidx.lifecycle.LiveData

/**
 * Created by crappy on 4/2/19.
 */
class NoteRepository(application: Application) {
private val noteDao:NoteDao
    private val Notes:LiveData<List<Note>>

    init{
        val database =NoteDatabase.getInstance(application)
        noteDao=database!!.noteDao()
        Notes=noteDao.getAllNotes()
    }

    fun insert(note:Note)
    {InsertAsyncTask(this.noteDao).execute(note)

    }
    fun update(note:Note)
    {
        Thread {
            noteDao.update(note)
        }

    }
    fun delete(note:Note)
    {
        Thread {
            noteDao.delete(note)
        }
    }
    fun deleteAll()
    { Thread {
        noteDao.deleteAllNotes()

    }
    }
    fun getAllNotes():LiveData<List<Note>>
    {

        return Notes
    }

      class InsertAsyncTask(private var noteDao: NoteDao) :AsyncTask<Note,Unit,Unit>(){

        override fun doInBackground(vararg params: Note?) {
            noteDao.insert(params[0]!!)
        }
    }
    val handler= Handler()





}