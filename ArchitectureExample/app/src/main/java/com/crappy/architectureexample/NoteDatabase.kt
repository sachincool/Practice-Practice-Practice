package com.crappy.architectureexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Created by crappy on 4/2/19.
 */
@Database(entities = arrayOf(Note::class),version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private var INSTANCE: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase? {
            if (INSTANCE == null)
                synchronized(NoteDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            NoteDatabase::class.java, "note_database.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(object:RoomDatabase.Callback(){
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                        val noteDao= INSTANCE!!.noteDao()
                                    Thread{
                                        noteDao.insert(Note(null,"Title 1","Description 1", 1))
                                        noteDao.insert(Note(null,"Title 1","Description 1", 1))
                                        noteDao.insert(Note(null,"Title 1","Description 1", 1))
                                    }
                                }

                                override fun onOpen(db: SupportSQLiteDatabase) {
                                    super.onOpen(db)
                                }
                            })
                            .build()
                }

            return INSTANCE
        }

    fun destroyInstance(){
        INSTANCE=null
    }

    }


}