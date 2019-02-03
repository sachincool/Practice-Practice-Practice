package com.crappy.quotesapp.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.crappy.quotesapp.R
import com.crappy.quotesapp.Utils.InjectorUtils
import com.crappy.quotesapp.data.Quote
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initialiseUI()
    }
    private fun initialiseUI(){
                val factory=InjectorUtils.provideQuotesViewModelFactory()
        val viewmodel=ViewModelProviders.of(this,factory)
                .get(QuotesViewModel::class.java)
        viewmodel.getQuotes().observe(this, Observer { quotes ->
            val sb=StringBuilder()
            quotes.forEach{
                quote->
                sb.append("$quote\n\n" )
            }
            textView_quotes.text=sb.toString()
        })
        button_add_quote.setOnClickListener{
            val quote=  Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewmodel.addQuotes(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }


    }




}
