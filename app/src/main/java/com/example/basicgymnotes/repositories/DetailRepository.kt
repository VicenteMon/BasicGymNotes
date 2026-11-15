package com.example.basicgymnotes.repositories

import com.example.basicgymnotes.database.AppDatabase
import com.example.basicgymnotes.entities.Machine


class DetailRepository(
    private val database : AppDatabase
){
    val dao = database.entryDao()

}