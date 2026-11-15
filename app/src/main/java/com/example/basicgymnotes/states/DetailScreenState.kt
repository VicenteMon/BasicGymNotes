package com.example.basicgymnotes.states

import com.example.basicgymnotes.entities.MachineWhitEntry
import kotlinx.serialization.descriptors.PrimitiveKind

data class DetailScreenState (
    val machineWhitEntries: MachineWhitEntry? = null,
    val dataImput: Float = 0.0f
)