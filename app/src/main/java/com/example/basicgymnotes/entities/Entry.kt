package com.example.basicgymnotes.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey
import java.util.Date

@Entity
data class Entry (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val machineId: Int,
    val weight: Float,
    val date: Date,
)