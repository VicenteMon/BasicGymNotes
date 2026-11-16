package com.example.basicgymnotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicgymnotes.entities.Entry
import com.example.basicgymnotes.viewmodels.EntryViewModel
import com.example.basicgymnotes.viewmodels.MachineViewModel


@Composable
fun DetailScreen(
    viewModel: EntryViewModel,
    navigateToMainScreen: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Column (
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Button(onClick = navigateToMainScreen) { Text(text = "Volver") }
        TextField(
            value = uiState.dataImput,
            onValueChange = {viewModel.setDataInput(it)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Button(onClick = {viewModel.createEntry()}) {
            Text(text = "Crear")
        }
        if(uiState.machineWhitEntries != null){
            Text(
                fontWeight = FontWeight.Bold,
                text = uiState.machineWhitEntries?.machine!!.name
            )
            for(entry: Entry in uiState.machineWhitEntries?.entries!!) {
                Text(text = "Peso: ${entry.weight} Fecha: ${entry.date}")
            }
        }

    }
}