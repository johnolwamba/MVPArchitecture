package com.safeboda.mvptutorial.ui

import android.content.Context
import com.safeboda.mvptutorial.model.Quote

class QuotesPresenter:
    QuotesContract.Presenter<QuotesContract.View> {

    private lateinit var view: QuotesContract.View

    private lateinit var context: Context

    override fun getQuotes() {
        view.showProgress()
        val quotes = arrayListOf(
            Quote(
                quote = "Imagination is more important than knowledge.",
                author = "-Albert Einstein"
            ),
            Quote(
                quote = "If you can't explain it simply, you don't understand it well enough.",
                author = "-Albert Einstein"
            ),
            Quote(
                quote = "Try not to become a man of success, but rather try to become a man of value.",
                author = "-Albert Einstein"
            )
        )
        if(quotes.isNotEmpty()) {
            view.hideProgress()
            view.handleQuotesSuccess(quotes)
        }else{
            view.hideProgress()
            view.handleQuotesFailure("There are no quotes available")
        }
    }

    override fun attach(view: QuotesContract.View) {
        this.view = view
        context = view as Context
    }
}