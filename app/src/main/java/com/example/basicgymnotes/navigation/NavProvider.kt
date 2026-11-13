package com.example.basicgymnotes.navigation

import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.basicgymnotes.database.AppDatabase
import com.example.basicgymnotes.repositories.GenericViewModelFactory
import com.example.basicgymnotes.repositories.MachineRepository
import com.example.basicgymnotes.screens.MachineMainScreen
import com.example.basicgymnotes.viewmodels.MachineViewModel
import kotlinx.serialization.Serializable

@Composable
fun NavProvider(applicationContext: Context, db: AppDatabase) {
    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    val machineRepository = MachineRepository(db)
                    val viewModel = viewModel<MachineViewModel>(
                        factory = GenericViewModelFactory(
                            MachineViewModel::class.java
                        ) {
                            MachineViewModel(machineRepository)
                        }
                    )
                    MachineMainScreen(viewModel)
                }
                is Detail -> NavEntry(key){

                }
                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )
}

@Serializable
data object Home

@Serializable
data class Detail(val id: Int)