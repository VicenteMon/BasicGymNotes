package com.example.basicgymnotes.utils

import java.text.Normalizer
import java.util.Locale

fun String.normalizeText(): String {
    return Normalizer
        .normalize(this, Normalizer.Form.NFD)
        .replace("\\p{Mn}+".toRegex(), "")
        .lowercase(Locale.ROOT)
        .trim()
}