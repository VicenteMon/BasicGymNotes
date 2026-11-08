package com.example.basicgymnotes.daos

import androidx.room3.Dao
import androidx.room3.Query
import com.example.basicgymnotes.entities.Machine

@Dao
interface MachineDao {
    @Query("SELECT * FROM machine")
    fun getAll(): List<Machine>
}