package com.example.basicgymnotes.database

import android.content.Context
import androidx.room3.Room
import androidx.sqlite.driver.AndroidSQLiteDriver


class AppDatabaseFactory {
    fun create(applicationContext: Context): AppDatabase {
        val db = Room.databaseBuilder<AppDatabase>(applicationContext,
            "notes-database")
            .setDriver(AndroidSQLiteDriver())
            .createFromAsset("database/init.db")
            .build()

        return db
    }
}