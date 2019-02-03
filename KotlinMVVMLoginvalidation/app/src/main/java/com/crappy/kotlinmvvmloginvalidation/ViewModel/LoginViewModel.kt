package com.crappy.kotlinmvvmloginvalidation.ViewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.crappy.kotlinmvvmloginvalidation.Interface.LoginResultCallback
import com.crappy.kotlinmvvmloginvalidation.Model.User

/**
 * Created by crappy on 2/2/19.
 */

class LoginViewModel(private val listener: LoginResultCallback):ViewModel(){

    private val user:User = User("","")
    val emailTextWatcher:TextWatcher
    get() = object:TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            user.setEmail(s.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }


    }


    val passwordTextWatcher:TextWatcher
        get() = object:TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }


        }
    fun onLoginClicked(v: View) {
        if (user.isDataValid)
            listener.onSuccess("Login Success")
        else listener.onFailure("Login error")
    }
}