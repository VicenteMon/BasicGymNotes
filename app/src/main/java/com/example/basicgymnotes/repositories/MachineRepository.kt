package com.example.basicgymnotes.repositories

import android.util.Log
import com.example.basicgymnotes.database.AppDatabase
import com.example.basicgymnotes.entities.Machine
import com.example.basicgymnotes.entities.MachineWhitEntry


class MachineRepository(
    private val database: AppDatabase
) {
    private val dao = database.machineDao()

    suspend fun getAllMachines(): List<Machine>{
        return dao.getAllMachines()
    }

    suspend fun getEntriesByMachineId(id: Int): MachineWhitEntry{
        return dao.getMachineWithEntries(id)
    }

    suspend fun insertMachine(machine: Machine){
        dao.insertMachine(machine)
    }
}