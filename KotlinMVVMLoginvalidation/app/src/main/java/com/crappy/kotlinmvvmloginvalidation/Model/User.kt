package com.crappy.kotlinmvvmloginvalidation.Model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

/**
 * Created by crappy on 2/2/19.
 */

class User (private var email:String,private var password:String): BaseObservable() {
val isDataValid:Boolean
    get()=(!TextUtils.isEmpty(getEmail()))
            && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
            && getPassword().length >6


     fun getPassword():String =password
     fun getEmail(): String =email

    fun setEmail(email:String){this.email=email}
    fun setPassword(password:String){this.password=password}


}