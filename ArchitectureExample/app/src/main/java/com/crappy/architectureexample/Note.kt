package com.crappy.architectureexample

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by crappy on 4/2/19.
 */

@Entity(tableName="note_table")
data class Note(
        @PrimaryKey(autoGenerate = true)
         var id: Int?,
         var title:String,
         var description: String,
         var priority:Int)