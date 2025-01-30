package com.effectivemobile.feature_main.models

import com.effectivemobile.domain.models.OfferModel
import com.effectivemobile.domain.models.VacancyModel

sealed class MainScreenViews : DiffEquals<MainScreenViews> {

    data object SearchSection : MainScreenViews() {

        override fun isSameItem(other: MainScreenViews): Boolean = true

        override fun isSameContent(other: MainScreenViews): Boolean = true
    }

    data class OffersSection(val offerList: List<OfferModel>) : MainScreenViews() {

        override fun isSameItem(other: MainScreenViews): Boolean = other is OffersSection

        override fun isSameContent(other: MainScreenViews): Boolean =
            other is OffersSection && offerList == other.offerList
    }

    data object TitleSection : MainScreenViews() {

        override fun isSameItem(other: MainScreenViews): Boolean = true

        override fun isSameContent(other: MainScreenViews): Boolean = true
    }

    data class VacancySection(val vacancy: VacancyModel) : MainScreenViews() {

        override fun isSameItem(other: MainScreenViews): Boolean = other is VacancySection

        override fun isSameContent(other: MainScreenViews): Boolean =
            other is VacancySection && vacancy == other.vacancy
    }

    data class ButtonSection(val vacancyNumber: Int) : MainScreenViews() {

        override fun isSameItem(other: MainScreenViews): Boolean = true

        override fun isSameContent(other: MainScreenViews): Boolean = true
    }
}

interface DiffEquals<T> {
    fun isSameItem(other: T): Boolean
    fun isSameContent(other: T): Boolean
}