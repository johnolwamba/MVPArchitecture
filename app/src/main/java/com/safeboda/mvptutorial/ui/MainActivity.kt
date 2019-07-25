package com.safeboda.mvptutorial.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.safeboda.mvptutorial.R
import com.safeboda.mvptutorial.extensions.gone
import com.safeboda.mvptutorial.extensions.show
import com.safeboda.mvptutorial.model.Quote
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), QuotesContract.View {

    private lateinit var presenter: QuotesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = QuotesPresenter()
        presenter.attach(this)
        initViews()
    }

    private fun initViews() {
        presenter.getQuotes()
    }

    override fun handleQuotesFailure(message: String) {
        Toast.makeText(this,"There are no Quotes", Toast.LENGTH_LONG).show()
    }

    override fun handleQuotesSuccess(quotes: ArrayList<Quote>) {
        revQuotes.apply {
            adapter = QuotesAdapter(quotes)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun showProgress() {
        pb.show()
    }

    override fun hideProgress() {
        pb.gone()
    }
}