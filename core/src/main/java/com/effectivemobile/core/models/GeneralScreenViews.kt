package com.effectivemobile.core.models

import com.effectivemobile.domain.models.OfferModel
import com.effectivemobile.domain.models.VacancyModel

sealed class GeneralScreenViews : DiffEquals<GeneralScreenViews> {

    data class AllVacanciesTopSection(val vacancyNumber: Int) : GeneralScreenViews() {

        override fun isSameItem(other: GeneralScreenViews): Boolean = other is AllVacanciesTopSection

        override fun isSameContent(other: GeneralScreenViews): Boolean = true
    }

    data class FavoriteTopSection(val vacancyNumber: Int) : GeneralScreenViews() {

        override fun isSameItem(other: GeneralScreenViews): Boolean = other is FavoriteTopSection

        override fun isSameContent(other: GeneralScreenViews): Boolean = true
    }

    data object SearchSection : GeneralScreenViews() {

        override fun isSameItem(other: GeneralScreenViews): Boolean = other is SearchSection

        override fun isSameContent(other: GeneralScreenViews): Boolean = true
    }

    data class OffersSection(val offerList: List<OfferModel>) : GeneralScreenViews() {

        override fun isSameItem(other: GeneralScreenViews): Boolean = other is OffersSection

        override fun isSameContent(other: GeneralScreenViews): Boolean =
            other is OffersSection && offerList == other.offerList
    }

    data object TitleSection : GeneralScreenViews() {

        override fun isSameItem(other: GeneralScreenViews): Boolean = other is TitleSection

        override fun isSameContent(other: GeneralScreenViews): Boolean = true
    }

    data class VacancySection(val vacancy: VacancyModel) : GeneralScreenViews() {

        override fun isSameItem(other: GeneralScreenViews): Boolean = other is VacancySection

        override fun isSameContent(other: GeneralScreenViews): Boolean =
            other is VacancySection && vacancy == other.vacancy
    }

    data class ButtonSection(val vacancyNumber: Int) : GeneralScreenViews() {

        override fun isSameItem(other: GeneralScreenViews): Boolean = other is ButtonSection

        override fun isSameContent(other: GeneralScreenViews): Boolean = true
    }
}

interface DiffEquals<T> {
    fun isSameItem(other: T): Boolean
    fun isSameContent(other: T): Boolean
}