package com.effectivemobile.data.remote.mapper

import com.effectivemobile.data.local.entity.AddressEntity
import com.effectivemobile.data.local.entity.ExperienceEntity
import com.effectivemobile.data.local.entity.SalaryEntity
import com.effectivemobile.data.local.entity.VacancyEntity
import com.effectivemobile.data.remote.response.AddressResponse
import com.effectivemobile.data.remote.response.ButtonResponse
import com.effectivemobile.data.remote.response.ExperienceResponse
import com.effectivemobile.data.remote.response.JobResponse
import com.effectivemobile.data.remote.response.OfferResponse
import com.effectivemobile.data.remote.response.SalaryResponse
import com.effectivemobile.data.remote.response.VacancyResponse
import com.effectivemobile.domain.models.AddressModel
import com.effectivemobile.domain.models.ButtonModel
import com.effectivemobile.domain.models.ExperienceModel
import com.effectivemobile.domain.models.JobModel
import com.effectivemobile.domain.models.OfferModel
import com.effectivemobile.domain.models.SalaryModel
import com.effectivemobile.domain.models.VacancyModel

fun JobResponse.toJob(): JobModel {
    return JobModel(
        offers = offers.toListOffers(),
        vacancies = vacancies.toListVacancy()
    )
}

fun OfferResponse.toOffer(): OfferModel {
    return OfferModel(
        id = id,
        title = title,
        link = link,
        button = button?.toButton()
    )
}

fun List<OfferResponse>.toListOffers(): List<OfferModel> {
    return this.map { it.toOffer() }
}

fun ButtonResponse.toButton(): ButtonModel {
    return ButtonModel(
        text = text
    )
}

fun VacancyResponse.toVacancy(): VacancyModel {
    return VacancyModel(
        id = id,
        lookingNumber = lookingNumber,
        title = title,
        address = address.toAddress(),
        company = company,
        experience = experience.toExperience(),
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = salary.toSalary(),
        schedules = schedules,
        appliedNumber = appliedNumber,
        description = description,
        responsibilities = responsibilities,
        questions = questions
    )
}

fun List<VacancyResponse>.toListVacancy(): List<VacancyModel> {
    return this.map { it.toVacancy() }
}

fun AddressResponse.toAddress(): AddressModel {
    return AddressModel(
        id = null,
        town = town,
        street = street,
        house = house
    )
}

fun ExperienceResponse.toExperience(): ExperienceModel {
    return ExperienceModel(
        id = null,
        previewText = previewText,
        text = text
    )
}

fun SalaryResponse.toSalary(): SalaryModel {
    return SalaryModel(
        id = null,
        full = full,
        short = short
    )
}

fun VacancyResponse.toVacancyEntity(): VacancyEntity {
    return VacancyEntity(
        id = id,
        lookingNumber = lookingNumber,
        title = title,
        address = address.toAddressEntity(),
        company = company,
        experience = experience.toExperienceEntity(),
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = salary.toSalaryEntity(),
        schedules = schedules,
        appliedNumber = appliedNumber,
        description = description,
        responsibilities = responsibilities,
        questions = questions
    )
}

fun List<VacancyResponse>.toListVacancyEntity(): List<VacancyEntity> {
    return this.map { it.toVacancyEntity() }
}

fun AddressResponse.toAddressEntity(): AddressEntity {
    return AddressEntity(
        id = 0,
        town = town,
        street = street,
        house = house
    )
}

fun ExperienceResponse.toExperienceEntity(): ExperienceEntity {
    return ExperienceEntity(
        id = 0,
        previewText = previewText,
        text = text
    )
}

fun SalaryResponse.toSalaryEntity(): SalaryEntity {
    return SalaryEntity(
        id = 0,
        full = full,
        short = short
    )
}