package com.effectivemobile.feature_main.utils

import com.effectivemobile.domain.models.JobModel
import com.effectivemobile.feature_main.models.MainScreenViews

fun convertToMainScreenViews(data: JobModel): List<MainScreenViews> {
    val sections = mutableListOf<MainScreenViews>()

    sections.add(MainScreenViews.SearchSection)

    if (data.offers.isNotEmpty()) {
        sections.add(MainScreenViews.OffersSection(data.offers))
    }

    sections.add(MainScreenViews.TitleSection)

    for (vacancy in data.vacancies) {
        sections.add(MainScreenViews.VacancySection(vacancy))
    }

    sections.add(MainScreenViews.ButtonSection(data.vacancies.size))

    return sections
}