package com.crappy.quotesapp.data

/**
 * Created by crappy on 3/2/19.
 */
class QuoteRepository private constructor(private val quotedao: FakeQuotedao){
    fun addQuote(quote:Quote){
        quotedao.addQuote(quote)
    }
    fun getQuotes()=quotedao.getQuote()

    companion object {
        @Volatile private var instance:QuoteRepository?=null
        fun getInstance(fakeQuotedao: FakeQuotedao)=
                instance?: synchronized(this){
                    instance?: QuoteRepository(fakeQuotedao).also { instance=it }
                }
    }
}