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
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import com.example.basicgymnotes.viewmodels.MachineViewModel


@Composable
fun MachineMainScreen(
    viewModel: MachineViewModel,
    navigateToDetailScreen: (id: Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column (
        modifier = Modifier.padding(20.dp)
    ) {

        Button(onClick = { navigateToDetailScreen(1)}) {
            Text(text = "Ir a detalle")
        }
        Text(fontWeight = FontWeight.Bold, text = "Machine Main Screen:" + uiState.machineList.size)
        uiState.machineList.forEach { machine ->
            Text(text = "Nombre: " + machine.name)
        }
        Button(onClick = {viewModel.loadMachines()}, content = {Text(text = "Load Machines")})
    }
}