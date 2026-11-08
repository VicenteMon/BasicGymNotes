package com.example.basicgymnotes.states

import com.example.basicgymnotes.entities.Machine

data class MachineScreenState (
    var machineList: List<Machine> = emptyList()
)