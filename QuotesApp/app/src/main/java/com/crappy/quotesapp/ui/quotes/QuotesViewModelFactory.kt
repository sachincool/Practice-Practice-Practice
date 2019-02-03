package com.crappy.quotesapp.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.crappy.quotesapp.data.QuoteRepository

/**
 * Created by crappy on 3/2/19.
 */
@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory(private val quotesRepository: QuoteRepository) :ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T

    }

}