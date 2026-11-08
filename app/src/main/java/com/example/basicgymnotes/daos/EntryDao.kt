package com.example.basicgymnotes.daos

import androidx.room3.Dao
import androidx.room3.Query
import com.example.basicgymnotes.entities.Entry

@Dao
interface EntryDao {
    @Query("SELECT * FROM entry")
    suspend fun getAll(): List<Entry>
}