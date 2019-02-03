package com.crappy.quotesapp.Utils

import com.crappy.quotesapp.data.FakeDatabase
import com.crappy.quotesapp.data.QuoteRepository
import com.crappy.quotesapp.ui.quotes.QuotesViewModelFactory

/**
 * Created by crappy on 3/2/19.
 */
object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository=QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)

    }
}