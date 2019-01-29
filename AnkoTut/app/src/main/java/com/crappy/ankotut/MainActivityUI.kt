package com.crappy.ankotut

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by crappy on 30/1/19.
 */
class MainActivityUI :AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui){
        frameLayout {
            val textField = editText {
                hint = "Text for toast and snackbars"

            }.lparams(width = matchParent) {
                margin = dip(12)
                topMargin = dip(30)

            }
            imageView(R.drawable.ic_art){
                onClick {
                    this@imageView.imageTintList= ColorStateList.valueOf(Color.parseColor("#4caf50"))
                }
            }.lparams(dip(72),dip(72)){
                gravity=Gravity.CENTER
            }
linearLayout{
button("Show Toast"){
    onClick { toast(textField.text) }
}
}.lparams{
    gravity=Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
    bottomMargin=dip(72)
}
        }
    }
}