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
import java.util.Calendar
import java.util.Date

class EntryViewModel(
    private val repository: MachineRepository,
    private val detailRepository: DetailRepository,
): ViewModel() {
    private val _uiState = MutableStateFlow(DetailScreenState())

    val uiState: StateFlow<DetailScreenState> get() = _uiState

    fun loadDetails(machineId: Int){
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(machineWhitEntries = repository.getEntriesByMachineId(machineId))
            Log.d("EntryViewModel", _uiState.value.machineWhitEntries.toString())
        }
    }

    fun setDataInput (data: String) {
        _uiState.value = _uiState.value.copy(dataInput = data)
    }

    fun createEntry(machineId: Int) {
        var input = 0.0f
        try {
            input = _uiState.value.dataInput.replace(",", ".").toFloat()

        }catch (ex: NumberFormatException){
            _uiState.value = _uiState.value.copy(isInputInvalid = true, dataInput = "")
            Log.d("EntryViewModel", "No se ha podido guardar ${_uiState.value.dataInput}")
            return
        }

        viewModelScope.launch {
            val entry = Entry(
                machineId = machineId,
                weight = input,
                repetitions = null,
                date = Calendar.getInstance().time,
            )

            detailRepository.create(entry)
            _uiState.value = _uiState.value.copy(isInputInvalid = false, dataInput = "")

            loadDetails(machineId)

        }
    }

    fun deleteEntry(entry: Entry){
        viewModelScope.launch {
            detailRepository.delete(entry)
            loadDetails(entry.machineId)
        }
    }

}