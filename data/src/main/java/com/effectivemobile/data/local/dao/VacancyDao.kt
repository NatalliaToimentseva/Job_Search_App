package com.effectivemobile.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.effectivemobile.data.local.entity.VacancyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VacancyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //считаем, что данные с сервера в приоритете
    suspend fun insertVacancy(listVacancy: List<VacancyEntity>)

    @Query("SELECT * FROM Vacancy")
    fun getAllVacancies(): Flow<List<VacancyEntity>>

    @Update
    suspend fun updateVacancy(vacancy: VacancyEntity)
}