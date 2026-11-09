package com.example.basicgymnotes.database

import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.example.basicgymnotes.daos.EntryDao
import com.example.basicgymnotes.daos.MachineDao
import com.example.basicgymnotes.entities.Entry
import com.example.basicgymnotes.entities.Machine

@Database(entities = [Machine::class, Entry::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun machineDao(): MachineDao
    abstract fun entryDao(): EntryDao
}