package com.example.basicgymnotes.screens

import androidx.compose.foundation.layout.Column
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
fun DetailScreen(
    machineId: Int,
    navigateToMainScreen: () -> Unit,
) {

    Column (
        modifier = Modifier.padding()
    ) {
        Button(onClick = navigateToMainScreen) { Text(text = "Volver") }
        Text(text = "Detail Screen : $machineId")
    }
}