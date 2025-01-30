package com.effectivemobile.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Experience")
data class ExperienceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo("preview_text")
    val previewText: String,
    @ColumnInfo("text")
    val text: String
)