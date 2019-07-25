package com.safeboda.mvptutorial.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(@PrimaryKey var primaryKey: Int? = null, val quote: String, val author: String)
