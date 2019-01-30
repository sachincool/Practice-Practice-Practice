 package com.crappy.material20

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    single_chip.setOnClickListener{
        it.visibility = View.INVISIBLE
    }
        bottom_app_bar.replaceMenu(R.menu.bottom_app_bar_menu)
        bottom_app_bar.setOnMenuItemClickListener{ MenuItem->
            when(MenuItem.itemId){
                R.id.action_bar_toast->  Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show()
                R.id.action_cart ->  Toast.makeText(this@MainActivity,"Cart ",Toast.LENGTH_SHORT).show()
                R.id.shipping -> Toast.makeText(this@MainActivity,"Shipping",Toast.LENGTH_SHORT).show()
                R.id.customer -> Toast.makeText(this@MainActivity,"Customer",Toast.LENGTH_SHORT).show()


            }
            true
        }
    }


}
