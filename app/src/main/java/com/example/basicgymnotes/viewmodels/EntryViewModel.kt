package com.example.basicgymnotes.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicgymnotes.entities.Entry
import com.example.basicgymnotes.repositories.DetailRepository
import com.example.basicgymnotes.repositories.MachineRepository
import com.example.basicgymnotes.states.DetailScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EntryViewModel(
    private val repository: MachineRepository,
    private val detailRepository: DetailRepository,
    private val machineId: Int,
): ViewModel() {
    private val _uiState = MutableStateFlow(DetailScreenState())

    val uiState: StateFlow<DetailScreenState> get() = _uiState

    init{
        loadDetails(machineId)
    }

    fun loadDetails(machineId: Int){
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(machineWhitEntries = repository.getEntriesByMachineId(machineId))
            Log.d("EntryViewModel", _uiState.value.machineWhitEntries.toString())
        }
    }

    fun setDataInput (data: Float) {
        _uiState.value = _uiState.value.copy(dataImput = data)
    }

    fun createEntry(entry: Entry){
        viewModelScope.launch {

        }
    }

}