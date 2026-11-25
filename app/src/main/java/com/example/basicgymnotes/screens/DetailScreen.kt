package com.example.basicgymnotes.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicgymnotes.components.MachineListComponent
import com.example.basicgymnotes.entities.Entry
import com.example.basicgymnotes.utils.toLocalDate
import com.example.basicgymnotes.viewmodels.EntryViewModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar


@SuppressLint("SimpleDateFormat")
@Composable
fun DetailScreen(
    innerPadding: PaddingValues,
    viewModel: EntryViewModel,
    navigateToMainScreen: () -> Unit,
    machineId: Int
) {
    val uiState by viewModel.uiState.collectAsState()

    val format = SimpleDateFormat("hh:mm dd")

    LaunchedEffect(machineId) {
        viewModel.loadDetails(machineId)
    }

    Column (
        modifier = Modifier.padding(innerPadding)
    ) {
        IconButton(onClick = navigateToMainScreen) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            TextField(
                modifier = Modifier.weight(0.8f),
                value = uiState.dataInput,
                onValueChange = {viewModel.setDataInput(it)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                isError = uiState.isInputInvalid
            )
            IconButton (
                modifier = Modifier.weight(0.2f),
                onClick = {viewModel.createEntry(machineId) }) {
                Icon(Icons.Default.Add, null)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        if(uiState.machineWhitEntries != null){
            Text(uiState.maxWeight?.toString() ?: "", fontSize = 60.sp, fontWeight = FontWeight.Bold)
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                text = uiState.machineWhitEntries?.machine!!.name
            )
            LazyColumn {
                items(uiState.machineWhitEntries?.entries!!.sortedByDescending {
                    it.date
                }){ entry ->
                    Row(
                        modifier = Modifier.fillMaxWidth().background(if(entry.date.toLocalDate() == LocalDate.now()) Color.LightGray else Color.Transparent),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(
                            verticalAlignment = Alignment.Bottom,
                        ) {
                            Text(text = "${entry.weight}", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                            Text(text = "Kg ")
                            Text(text = "${format.format(entry.date)}")
                        }

                        IconButton(onClick = {viewModel.deleteEntry(entry)}) {
                            Icon(Icons.Default.Delete, null)
                        }
                    }
                    Box(modifier = Modifier.fillMaxSize().background(if(entry.date.toLocalDate() == LocalDate.now()) Color.Gray else Color.LightGray).height(1.dp))
                }
            }


        }

    }
}