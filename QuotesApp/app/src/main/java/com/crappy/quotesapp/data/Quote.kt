package com.crappy.quotesapp.data

/**
 * Created by crappy on 3/2/19.
 */
data class Quote(val quoteText:String,
                 val author:String){
    override fun toString(): String {
        return "$quoteText - $author"
    }
}