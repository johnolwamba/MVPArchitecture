package com.safeboda.mvptutorial.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.safeboda.mvptutorial.QuotesApplication
import com.safeboda.mvptutorial.model.Quote

@Database(
    entities = [Quote::class],
    version = 1,
    exportSchema = false
)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun quotesDao(): QutoesDao

    companion object {
        val db = synchronized(QuotesDatabase::class.java) {
            Room.databaseBuilder(
                QuotesApplication.applicationContext(),
                QuotesDatabase::class.java, "quotes_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}