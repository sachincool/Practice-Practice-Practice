package com.crappy.architectureexample

import android.app.Application
import androidx.lifecycle.ViewModel

/**
 * Created by crappy on 4/2/19.
 */
class NoteViewModel(context: Application) :ViewModel(){

    private  val noteRepository=NoteRepository(context)
    private    val allNotes=noteRepository.getAllNotes()

    fun insert(note:Note) =noteRepository.insert(note)
    fun update(note:Note)=noteRepository.update(note)
    fun delete(note:Note)=noteRepository.delete(note)
    fun deleteAll()=noteRepository.deleteAll()
    fun getAllNotes()=allNotes


}