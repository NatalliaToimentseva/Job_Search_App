package com.effectivemobile.data.local.mapper

import com.effectivemobile.data.local.entity.AddressEntity
import com.effectivemobile.data.local.entity.ExperienceEntity
import com.effectivemobile.data.local.entity.SalaryEntity
import com.effectivemobile.data.local.entity.VacancyEntity
import com.effectivemobile.domain.models.AddressModel
import com.effectivemobile.domain.models.ExperienceModel
import com.effectivemobile.domain.models.SalaryModel
import com.effectivemobile.domain.models.VacancyModel

fun VacancyEntity.toVacancy(
): VacancyModel {
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

fun List<VacancyEntity>.toListVacancy(): List<VacancyModel> {
    return this.map { it.toVacancy() }
}

fun AddressEntity.toAddress(): AddressModel {
    return AddressModel(
        id = id,
        town = town,
        street = street,
        house = house
    )
}

fun ExperienceEntity.toExperience(): ExperienceModel {
    return ExperienceModel(
        id = id,
        previewText = previewText,
        text = text
    )
}

fun SalaryEntity.toSalary(): SalaryModel {
    return SalaryModel(
        id = id,
        full = full,
        short = short
    )
}

fun VacancyModel.toVacancyEntity(): VacancyEntity {
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

fun List<VacancyModel>.toListVacancyEntity(): List<VacancyEntity> {
    return this.map { it.toVacancyEntity() }
}

fun AddressModel.toAddressEntity(): AddressEntity {
    return AddressEntity(
        id = id ?: 0,
        town = town,
        street = street,
        house = house
    )
}

fun ExperienceModel.toExperienceEntity(): ExperienceEntity {
    return ExperienceEntity(
        id = id ?: 0,
        previewText = previewText,
        text = text
    )
}

fun SalaryModel.toSalaryEntity(): SalaryEntity {
    return SalaryEntity(
        id = id ?: 0,
        full = full,
        short = short
    )
}