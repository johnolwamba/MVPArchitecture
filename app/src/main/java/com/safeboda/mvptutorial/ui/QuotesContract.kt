package com.safeboda.mvptutorial.ui

import com.safeboda.mvptutorial.model.Quote

class QuotesContract {

    interface Presenter<in T> {

        fun attach(view: T)

        fun getQuotes()
    }

    interface View {

        fun showProgress()

        fun hideProgress()

        fun handleQuotesSuccess(quotes: ArrayList<Quote>)

        fun handleQuotesFailure(message: String)

    }
}
