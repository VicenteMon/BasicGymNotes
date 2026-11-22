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

    var mainList: List<Machine> = listOf()

    init{
        loadMachines()
    }


    fun loadMachines(){
        viewModelScope.launch {
            mainList = repository.getAllMachines()
            _uiState.value = _uiState.value.copy(machineList = mainList)
            Log.d("MachinesViewModel", _uiState.value.machineList.toString())
        }
    }

    // TODO: Mejorar con la búsqueda en base de datos
    fun filterMachine(searchText: String){
        _uiState.value = _uiState.value.copy(searchText = searchText)

        val machineListFiltered: List<Machine> = mainList.filter { machine ->
            machine.name.normalizeText().contains(
                _uiState.value.searchText.normalizeText()
            )
        }

        _uiState.value = _uiState.value.copy(machineList = machineListFiltered)
    }

}