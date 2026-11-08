package com.example.basicgymnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicgymnotes.database.AppDatabaseFactory
import com.example.basicgymnotes.repositories.MachineRepository
import com.example.basicgymnotes.screens.MachineMainScreen
import com.example.basicgymnotes.ui.theme.BasicGymNotesTheme
import com.example.basicgymnotes.viewmodels.MachineViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = AppDatabaseFactory().create(applicationContext)
        val machineRepository = MachineRepository(db)
        val viewModel = MachineViewModel(machineRepository)
        setContent {
            BasicGymNotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MachineMainScreen(viewModel, innerPadding)
                }
            }
        }
    }
}