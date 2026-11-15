package com.example.basicgymnotes.repositories

import com.example.basicgymnotes.database.AppDatabase
import com.example.basicgymnotes.entities.Entry
import com.example.basicgymnotes.entities.Machine
import com.example.basicgymnotes.entities.MachineWhitEntry


class DetailRepository(
    private val database : AppDatabase
){
    val dao = database.entryDao()

    suspend fun create(entry: Entry){
        dao.create(entry)
    }
}