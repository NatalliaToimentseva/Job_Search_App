package com.effectivemobile.feature_main.utils

import com.effectivemobile.domain.models.OfferModel
import com.effectivemobile.domain.models.VacancyModel
import com.effectivemobile.core.commonModels.GeneralScreenViews

fun convertToMainScreenViews(
    isAllVacancies: Boolean,
    offers: List<OfferModel>,
    vacancies: List<VacancyModel>
): List<GeneralScreenViews> {
    val sections = mutableListOf<GeneralScreenViews>()

    if (isAllVacancies) {
        sections.add(GeneralScreenViews.AllVacanciesTopSection(vacancies.size))
        for (vacancy in vacancies) {
            sections.add(GeneralScreenViews.VacancySection(vacancy))
        }
    } else {
        sections.add(GeneralScreenViews.SearchSection)

        if (offers.isNotEmpty()) {
            sections.add(GeneralScreenViews.OffersSection(offers))
        }

        sections.add(GeneralScreenViews.TitleSection)

        for (vacancy in vacancies.take(3)) {
            sections.add(GeneralScreenViews.VacancySection(vacancy))
        }

        sections.add(GeneralScreenViews.ButtonSection(vacancies.size))
    }

    return sections
}