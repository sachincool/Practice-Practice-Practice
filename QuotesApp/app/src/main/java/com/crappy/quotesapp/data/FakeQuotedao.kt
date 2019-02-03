package com.crappy.quotesapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by crappy on 3/2/19.
 */
class FakeQuotedao{
    private val quoteList= mutableListOf<Quote>()
    private val quotes=MutableLiveData<List<Quote>>()
    init {
        quotes.value=quoteList
    }
    fun addQuote(quote:Quote){
        quoteList.add(quote)
        quotes.value=quoteList
    }

    fun getQuote()=quotes as LiveData<List<Quote>>


}