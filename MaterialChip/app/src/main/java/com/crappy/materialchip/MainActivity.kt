package com.crappy.materialchip

import android.os.Bundle
import android.support.design.chip.Chip
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chip.setOnClickListener {
            Toast.makeText(this@MainActivity,"Close Action",Toast.LENGTH_SHORT).show()
                }
        chip.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this@MainActivity, "check changed $isChecked",Toast.LENGTH_SHORT).show()
        }
        add_tag.setOnClickListener {
            val text_arr=input.text!!.toString().split(" ").dropLastWhile { it.isEmpty() }.toTypedArray()
            val inflater=LayoutInflater.from(this@MainActivity)
            for(text in text_arr){
                val chip_item=inflater.inflate(R.layout.chip_item,null,false) as Chip
                chip_item.text=text
                chip_item.setOnCloseIconClickListener { view ->
                    chip_group.removeView(view)
                }
                chip_group.addView(chip_item)
            }


        }
get_selected.setOnClickListener {
    var  result:StringBuilder= StringBuilder()
    for(i in 0 until chip_group.childCount)
    {
        val chip=chip_group.getChildAt(i) as Chip
        if (chip.isChecked)
            result.append(chip.text).append(",")
    }
    Toast.makeText(this@MainActivity, result.toString(),Toast.LENGTH_SHORT).show()


}


    }
}
