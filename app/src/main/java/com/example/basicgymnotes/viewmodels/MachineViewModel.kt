package com.example.basicgymnotes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicgymnotes.entities.Machine
import com.example.basicgymnotes.repositories.MachineRepository
import com.example.basicgymnotes.states.MachineScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MachineViewModel(
    private val repository: MachineRepository
): ViewModel() {
    private val _state = MutableStateFlow(MachineScreenState())

    val state = _state.asStateFlow()

    init{
        loadMachines()
    }


    fun loadMachines(){
        viewModelScope.launch {
            _state.value.machineList = repository.getAllMachines()
        }
    }

}