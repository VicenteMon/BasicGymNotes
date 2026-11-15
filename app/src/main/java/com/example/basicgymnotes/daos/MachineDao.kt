package com.example.basicgymnotes.daos

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Transaction
import com.example.basicgymnotes.entities.Machine
import com.example.basicgymnotes.entities.MachineWhitEntry

@Dao
interface MachineDao {
    @Query("SELECT * FROM machine")
    suspend fun getAllMachines(): List<Machine>

    @Transaction
    @Query("SELECT * FROM machine WHERE id = :id")
    suspend fun getMachineWithEntries(id: Int): List<MachineWhitEntry>

    @Insert
    suspend fun insertMachine(machine: Machine)
}