package com.effectivemobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class JobResponse(
    @SerializedName("offers")
    val offers: List<OfferResponse>,
    @SerializedName("vacancies")
    val vacancies: List<VacancyResponse>,
)

data class OfferResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("button")
    val button: ButtonResponse?,
)

data class ButtonResponse(
    @SerializedName("text")
    val text: String,
)

data class VacancyResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("lookingNumber")
    val lookingNumber: Long?,
    @SerializedName("title")
    val title: String,
    @SerializedName("address")
    val address: AddressResponse,
    @SerializedName("company")
    val company: String,
    @SerializedName("experience")
    val experience: ExperienceResponse,
    @SerializedName("publishedDate")
    val publishedDate: String,
    @SerializedName("isFavorite")
    val isFavorite: Boolean,
    @SerializedName("salary")
    val salary: SalaryResponse,
    @SerializedName("schedules")
    val schedules: List<String>,
    @SerializedName("appliedNumber")
    val appliedNumber: Long?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("responsibilities")
    val responsibilities: String,
    @SerializedName("questions")
    val questions: List<String>,
)

data class AddressResponse(
    @SerializedName("town")
    val town: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("house")
    val house: String,
)

data class ExperienceResponse(
    @SerializedName("previewText")
    val previewText: String,
    @SerializedName("text")
    val text: String,
)

data class SalaryResponse(
    @SerializedName("full")
    val full: String,
    @SerializedName("short")
    val short: String?,
)