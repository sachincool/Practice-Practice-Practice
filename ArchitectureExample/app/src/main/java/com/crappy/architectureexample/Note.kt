package com.crappy.architectureexample

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by crappy on 4/2/19.
 */

@Entity(tableName="note_table")
data class Note(
        @PrimaryKey(autoGenerate = true)
         val id: Int?,
         val title:String,
         val description: String,
         val priority:Int)