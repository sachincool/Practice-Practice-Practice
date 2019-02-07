package com.crappy.architectureexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNote : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        number_picker_priority.minValue=1
        number_picker_priority.maxValue=10
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)
        title="Add Note"


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

            return when(item?.itemId){
                R.id.save_note -> saveNote()
                else -> super.onOptionsItemSelected(item)
            }

    }

    private fun saveNote(): Boolean {
        if(edit_txt_title.text.toString().trim().isEmpty() || edit_txt_description.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Please insert the title and description", Toast.LENGTH_SHORT).show()
            return false
        }
        intent= Intent()
        intent.putExtra("title",edit_txt_title.text.toString())
        intent.putExtra("description",edit_txt_description.text.toString())
        intent.putExtra("numberpicker",number_picker_priority.value)
        setResult(Activity.RESULT_OK,intent)
        finish()
        return true

    }
}
