package com.example.basicgymnotes.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class Entry (
    @PrimaryKey val id: Int,
    val weight: String,
    val date: String,
)