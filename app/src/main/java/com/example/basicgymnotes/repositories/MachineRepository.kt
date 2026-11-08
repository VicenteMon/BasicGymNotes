package com.example.basicgymnotes.repositories

import com.example.basicgymnotes.database.AppDatabase
import com.example.basicgymnotes.entities.Machine


class MachineRepository(
    private val database: AppDatabase
) {
    private val dao = database.machineDao()

    suspend fun getAllMachines(): List<Machine>{
        return dao.getAllMachines()
    }

    suspend fun insertMachine(machine: Machine){
        dao.insertMachine(machine)
    }
}