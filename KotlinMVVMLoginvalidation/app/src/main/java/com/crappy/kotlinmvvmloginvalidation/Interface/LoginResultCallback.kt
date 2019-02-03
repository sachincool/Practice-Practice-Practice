package com.crappy.kotlinmvvmloginvalidation.Interface

/**
 * Created by crappy on 2/2/19.
 */
interface LoginResultCallback {
    fun onSuccess(message:String)
    fun onFailure(message: String)



}