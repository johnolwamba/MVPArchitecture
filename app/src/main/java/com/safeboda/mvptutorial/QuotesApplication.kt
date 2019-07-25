package com.safeboda.mvptutorial

import android.app.Application
import android.content.Context

class QuotesApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: QuotesApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}