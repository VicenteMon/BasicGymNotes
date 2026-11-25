package com.example.basicgymnotes.utils

import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

fun Date.toLocalDate(): LocalDate =
    toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate()