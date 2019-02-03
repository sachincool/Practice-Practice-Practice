package com.crappy.quotesapp.data

/**
 * Created by crappy on 3/2/19.
 */
class FakeDatabase private constructor(){
     var quoteDao=FakeQuotedao()

    companion object {
        @Volatile private var instance:FakeDatabase?=null
        fun getInstance()=
                instance?: synchronized(this){
                    instance?: FakeDatabase().also { instance=it }
                }
    }

}