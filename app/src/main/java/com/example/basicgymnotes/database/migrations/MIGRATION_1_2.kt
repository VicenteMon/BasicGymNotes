package com.example.basicgymnotes.database.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL


//
// ACTUALMENTE NO HACE NADA, PERO SE QUEDA COMO EJEMPLO DE UNA MIGRACIÓN
//
val MIGRATION_1_2 = object : Migration(1, 2) {
    override suspend fun migrate(connection: SQLiteConnection) {

        connection.execSQL(
            """
            INSERT INTO Machine (id, name, image)
            VALUES (1, 'Press Banca', 'src/press_banca.png')
            """.trimIndent()
        )

        connection.execSQL(
            """
            INSERT INTO Machine (id, name, image)
            VALUES (2, 'Cuádriceps', 'src/cuadriceps.png')
            """.trimIndent()
        )

        connection.execSQL(
            """
            INSERT INTO Machine (id, name, image)
            VALUES (3, 'Jalón al Pecho', 'src/jalon_al_pecho.png')
            """.trimIndent()
        )
    }
}