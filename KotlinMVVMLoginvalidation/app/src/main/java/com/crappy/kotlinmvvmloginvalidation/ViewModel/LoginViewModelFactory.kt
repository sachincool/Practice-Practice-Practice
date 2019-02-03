package com.crappy.kotlinmvvmloginvalidation.ViewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.crappy.kotlinmvvmloginvalidation.Interface.LoginResultCallback

/**
 * Created by crappy on 2/2/19.
 */
class LoginViewModelFactory(private val listener:LoginResultCallback): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}