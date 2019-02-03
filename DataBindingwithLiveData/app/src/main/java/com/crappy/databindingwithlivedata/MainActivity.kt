package com.crappy.databindingwithlivedata

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel=ViewModelProviders.of(this).get(MainViewModel::class.java)

        DataBindingUtil.setContentView<com.crappy.databindingwithlivedata.databinding.ActivityMainBinding>(this,R.layout.activity_main)
                .apply {
                    this.lifecycleOwner = this@MainActivity
                    this.viewmodel=mainViewModel
                }
        mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this@MainActivity,it,Toast.LENGTH_SHORT).show()
        })
    }

}
