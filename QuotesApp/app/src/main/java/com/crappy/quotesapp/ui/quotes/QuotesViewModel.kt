package com.crappy.quotesapp.ui.quotes

import androidx.lifecycle.ViewModel
import com.crappy.quotesapp.data.Quote
import com.crappy.quotesapp.data.QuoteRepository

/**
 * Created by crappy on 3/2/19.
 */
class QuotesViewModel(private val quoteRepository: QuoteRepository):ViewModel() {

    fun getQuotes()=quoteRepository.getQuotes()

    fun addQuotes(quote: Quote)=quoteRepository.addQuote(quote)

}