package com.example.basicgymnotes.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicgymnotes.entities.Machine
import com.example.basicgymnotes.repositories.MachineRepository
import com.example.basicgymnotes.states.MachineScreenState
import com.example.basicgymnotes.utils.normalizeText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MachineViewModel(
    private val repository: MachineRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(MachineScreenState())

    val uiState: StateFlow<MachineScreenState> get() = _uiState

    init{
        loadMachines()
    }


    fun loadMachines(){
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(machineList = repository.getAllMachines())
            Log.d("MachinesViewModel", _uiState.value.machineList.toString())
        }
    }

    fun filterMachine(searchText: String){
        _uiState.value = _uiState.value.copy(searchText = searchText)

        val machineListFiltered: List<Machine> = _uiState.value.machineList.filter { machine ->
            machine.name.normalizeText().contains(
                _uiState.value.searchText.normalizeText()
            )
        }

        _uiState.value = _uiState.value.copy(machineList = machineListFiltered)
    }

}