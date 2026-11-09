package com.example.basicgymnotes.states

import com.example.basicgymnotes.entities.Machine

data class MachineScreenState (
    val machineList: List<Machine> = emptyList()
)