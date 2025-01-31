package com.effectivemobile.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Vacancy")
data class VacancyEntity(
    @PrimaryKey
    @ColumnInfo("vacancy_id")
    val id: String,
    @ColumnInfo("looking_number")
    val lookingNumber: Long?,
    @ColumnInfo("title")
    val title: String,
    @Embedded
    val address: AddressEntity,
    @ColumnInfo("company")
    val company: String,
    @Embedded
    val experience: ExperienceEntity,
    @ColumnInfo("published_date")
    val publishedDate: String,
    @ColumnInfo("is_favorite")
    val isFavorite: Boolean,
    @Embedded
    val salary: SalaryEntity,
    @ColumnInfo("schedules")
    val schedules: List<String>,
    @ColumnInfo("appliedNumber")
    val appliedNumber: Long?,
    @ColumnInfo("description")
    val description: String?,
    @ColumnInfo("responsibilities")
    val responsibilities: String,
    @ColumnInfo("questions")
    val questions: List<String>
)