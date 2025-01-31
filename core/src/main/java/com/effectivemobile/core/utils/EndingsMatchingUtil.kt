package com.effectivemobile.core.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun matchVacancies(number: Int): String {
    return when {
        number % 10 == 1 && number % 100 != 11 -> "$number вакансия"
        number % 10 in 2..4 && number % 100 !in 12..14 -> "$number вакансии"
        else -> "$number вакансий"
    }
}

fun matchLookingNumber(number: Long): String {
    return when {
        number % 10 in 2..4 && number % 100 !in 12..14 -> "$number человека"
        else -> "$number человек"
    }
}

fun matchMonths(data: String): String {
    val date = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val day = date.dayOfMonth

    return when (date.monthValue) {
        1 -> "$day января"
        2 -> "$day февраля"
        3 -> "$day марта"
        4 -> "$day апреля"
        5 -> "$day мая"
        6 -> "$day июня"
        7 -> "$day июля"
        8 -> "$day августа"
        9 -> "$day сентября"
        10 -> "$day октября"
        11 -> "$day ноября"
        else -> "$day декабря"
    }
}