package com.example.basicgymnotes.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class Entry (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val weight: String,
    val date: String,
)