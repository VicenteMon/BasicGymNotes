package com.example.basicgymnotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.basicgymnotes.viewmodels.MachineViewModel


@Composable
fun MachineMainScreen(
    viewModel: MachineViewModel,
    innerPadding: PaddingValues,
) {
    val uiState by viewModel.uiState.collectAsState()

    Column (
        modifier = Modifier.padding(innerPadding)
    ) {
        Text(fontWeight = FontWeight.Bold, text = "Machine Main Screen:" + uiState.machineList.size)
        uiState.machineList.forEach { machine ->
            Text(text = "Nombre: " + machine.name)
        }
        Button(onClick = {viewModel.loadMachines()}, content = {Text(text = "Load Machines")})
    }
}