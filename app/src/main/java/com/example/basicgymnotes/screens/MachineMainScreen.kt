package com.example.basicgymnotes.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicgymnotes.components.MachineListComponent
import com.example.basicgymnotes.viewmodels.MachineViewModel


@Composable
fun MachineMainScreen(
    viewModel: MachineViewModel,
    navigateToDetailScreen: (id: Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).padding(horizontal = 16.dp),
        ) {
            TextField(
                value = uiState.searchText,
                onValueChange = {viewModel.filterMachine(it)},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Buscar...") },
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text(fontWeight = FontWeight.Bold, fontSize = 25.sp, text = "Página principal:" + uiState.machineList.size)
                Button(onClick = {viewModel.loadMachines()}, content = {Text(text = "Load Machines")})
            }

            LazyColumn {
                items(uiState.machineList){ machine ->
                    MachineListComponent(machine = machine, navigateToDetailScreen = navigateToDetailScreen)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

        }
    }

}