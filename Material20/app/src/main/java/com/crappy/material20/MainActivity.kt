 package com.crappy.material20

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_app_bar)
    single_chip.setOnClickListener{
        it.visibility = View.INVISIBLE
    }
    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.bottom_app_bar_menu,menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         when (item?.itemId){
             R.id.action_bar_toast->  Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show()
         }
return true
     }
}
