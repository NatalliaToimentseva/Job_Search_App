package com.effectivemobile.domain.models

data class JobModel(
    val offers: List<OfferModel>,
    val vacancies: List<VacancyModel>,
)

data class OfferModel(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonModel?,
)

data class ButtonModel(
    val text: String,
)

data class VacancyModel(
    val id: String,
    val lookingNumber: Long?,
    val title: String,
    val address: AddressModel,
    val company: String,
    val experience: ExperienceModel,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryModel,
    val schedules: List<String>,
    val appliedNumber: Long?,
    val description: String?,
    val responsibilities: String,
    val questions: List<String>
)

data class AddressModel(
    val town: String,
    val street: String,
    val house: String,
)

data class ExperienceModel(
    val previewText: String,
    val text: String,
)

data class SalaryModel(
    val full: String,
    val short: String?,
)