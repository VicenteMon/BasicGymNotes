package com.example.basicgymnotes.entities

import androidx.room3.Embedded
import androidx.room3.Relation

data class MachineWhitEntry(
    @Embedded val machine: Machine,
    @Relation(
        parentColumns = ["id"],
        entityColumns = ["machineId"]
    )
    val entries: List<Entry>
)
