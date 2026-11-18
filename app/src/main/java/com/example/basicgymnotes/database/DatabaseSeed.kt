package com.example.basicgymnotes.database

import androidx.room3.RoomDatabase
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.example.basicgymnotes.entities.Machine




class DatabaseSeed : RoomDatabase.Callback() {
    val machines = listOf(
        Machine(
            name = "Press Banca",
            image = "src/press_banca.png"
        ),
        Machine(
            name = "Press Banca Inclinado",
            image = "src/press_banca_inclinado.png"
        ),
        Machine(
            name = "Aperturas",
            image = "src/aperturas.png"
        ),
        Machine(
            name = "Extensión de triceps en polea baja",
            image = "src/extension_de_triceps_en_polea_baja.png"
        ),
        Machine(
            name = "Extensión de triceps en polea alta",
            image = "src/extension_de_triceps_en_polea_alta.png"
        ),
        Machine(
            name = "Jalón al Pecho",
            image = "src/jalon_al_pecho.png"
        ),
        Machine(
            name = "Remo",
            image = "src/remo.png"
        ),
        Machine(
            name = "Aperturas inversas en máquina",
            image = "src/aperturas_inversas_en_maquina.png"
        ),
        Machine(
            name = "Curl de biceps predicador",
            image = "src/curl_de_biceps_predicador.png"
        ),
        Machine(
            name = "Curl de biceps inclinado",
            image = "src/curl_de_biceps_inclinado.png"
        ),
        // TODO: Añadir los ejercicios del día de pierna
        Machine(
            name = "Cuádriceps",
            image = "src/cuadriceps.png"
        ),

    )

    override suspend fun onCreate(connection: SQLiteConnection) {

        machines.forEach { machine ->

            connection.execSQL(
                """
                INSERT INTO Machine (name, image)
                VALUES ('${machine.name}', '${machine.image}')
                """.trimIndent()
            )

        }
    }
}