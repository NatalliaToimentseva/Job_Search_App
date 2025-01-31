package com.effectivemobile.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.effectivemobile.data.local.dao.VacancyDao
import com.effectivemobile.data.local.entity.AddressEntity
import com.effectivemobile.data.local.entity.ExperienceEntity
import com.effectivemobile.data.local.entity.SalaryEntity
import com.effectivemobile.data.local.entity.VacancyEntity
import com.effectivemobile.data.dbUtils.DbListConverter

@Database(
    version = 1,
    entities = [
        VacancyEntity::class,
        AddressEntity::class,
        ExperienceEntity::class,
        SalaryEntity::class],

    )
@TypeConverters(DbListConverter::class)
abstract class JobSearchAppDB : RoomDatabase() {

    abstract fun getVacancyDao(): VacancyDao
}