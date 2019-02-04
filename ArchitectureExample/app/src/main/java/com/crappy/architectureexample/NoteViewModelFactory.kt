package com.crappy.architectureexample

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by crappy on 5/2/19.
 */
class NoteViewModelFactory(val context:Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(context) as T
    }
}