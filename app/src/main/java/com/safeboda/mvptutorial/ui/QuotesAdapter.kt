package com.safeboda.mvptutorial.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.safeboda.mvptutorial.R
import com.safeboda.mvptutorial.model.Quote
import kotlinx.android.synthetic.main.item_layout_quotes.view.*


class QuotesAdapter(private val quotes: ArrayList<Quote>) :
    RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_quotes, parent, false)
        return QuotesViewHolder(view)
    }

    override fun getItemCount(): Int = quotes.size

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.setUpViewHolder(quotes[position])
    }

    inner class QuotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtQuotes : AppCompatTextView = itemView.txtQuotes
        private val txtAuthor : AppCompatTextView = itemView.txtAuthor

        fun setUpViewHolder(quote: Quote) {
            with(quote){
                txtQuotes.text = this.quote
                txtAuthor.text = author
            }
        }
    }
}