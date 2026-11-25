package com.example.basicgymnotes.database

import android.util.Log
import androidx.room3.RoomDatabase
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.example.basicgymnotes.entities.Machine




class DatabaseSeed : RoomDatabase.Callback() {
    val machines = listOf(
        Machine(
            name = "Press Banca",
            isMachine = false,
            image = null

        ),
        Machine(
            name = "Press Banca Inclinado",
            isMachine = false,
            image = null
        ),
        Machine(
            name = "Aperturas",
            isMachine = true,
            image = null
        ),
        Machine(
            name = "Extensión de triceps en polea baja",
            isMachine = true,
            image = null
        ),
        Machine(
            name = "Extensión de triceps en polea alta",
            isMachine = true,
            image = null
        ),
        Machine(
            name = "Jalón al Pecho",
            isMachine = true,
            image = null
        ),
        Machine(
            name = "Remo",
            isMachine = true,
            image = null
        ),
        Machine(
            name = "Aperturas inversas en máquina",
            isMachine = true,
            image = null
        ),
        Machine(
            name = "Curl de biceps predicador",
            isMachine = false,
            image = null
        ),
        Machine(
            name = "Curl de biceps inclinado",
            isMachine = false,
            image = null
        ),
        // TODO: Añadir los ejercicios del día de pierna
        Machine(
            name = "Cuádriceps",
            isMachine = true,
            image = null
        ),

    )

    override suspend fun onCreate(connection: SQLiteConnection) {

        machines.forEach { machine ->

            connection.execSQL(
                """
                INSERT INTO Machine (name, isMachine)
                VALUES ('${machine.name}', ${machine.isMachine})
                """.trimIndent()
            )
            Log.d("DatabaseSeed", "machine ${machine.toString()}")
        }
    }
}