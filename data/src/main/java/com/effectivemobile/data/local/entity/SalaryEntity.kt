package com.effectivemobile.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Salary")
data class SalaryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("salary_id")
    val id: Long = 0,
    @ColumnInfo("full")
    val full: String,
    @ColumnInfo("short")
    val short: String?
)