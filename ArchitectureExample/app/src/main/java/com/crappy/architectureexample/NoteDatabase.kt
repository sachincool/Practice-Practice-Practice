package com.crappy.architectureexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by crappy on 4/2/19.
 */
@Database(entities = [Note::class],version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private var INSTANCE: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase? {
            if (INSTANCE == null)
                synchronized(NoteDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context,
                            NoteDatabase::class.java, "note_database.db")
                            .fallbackToDestructiveMigration()
                            .build()
                }

            return INSTANCE
        }

    fun destroyInstance(){
        INSTANCE=null
    }

    }

}