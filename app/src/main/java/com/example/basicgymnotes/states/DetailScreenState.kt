package com.example.basicgymnotes.states

import com.example.basicgymnotes.entities.MachineWhitEntry

data class DetailScreenState (
    val machineWhitEntries: MachineWhitEntry? = null,
    val isInputInvalid: Boolean = false,
    val dataInput: String = ""
)