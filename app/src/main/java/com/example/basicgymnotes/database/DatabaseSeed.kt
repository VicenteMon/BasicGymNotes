package com.example.basicgymnotes.database

import androidx.room3.RoomDatabase
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.example.basicgymnotes.entities.Machine




class DatabaseSeed : RoomDatabase.Callback() {
    val machines = listOf(
        Machine(
            id = 1,
            name = "Press Banca",
            image = "src/press_banca.png"
        ),
        Machine(
            id = 2,
            name = "Cuádriceps",
            image = "src/cuadriceps.png"
        ),
        Machine(
            id = 3,
            name = "Jalón al Pecho",
            image = "src/jalon_al_pecho.png"
        )
    )

    override suspend fun onCreate(connection: SQLiteConnection) {

        machines.forEach { machine ->

            connection.execSQL(
                """
                INSERT INTO Machine (id, name, image)
                VALUES ('${machine.id}', '${machine.name}', '${machine.image}')
                """.trimIndent()
            )

        }
    }
}