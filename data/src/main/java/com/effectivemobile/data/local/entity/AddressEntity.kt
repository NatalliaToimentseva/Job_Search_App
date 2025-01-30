package com.effectivemobile.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Address")
data class AddressEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo("town")
    val town: String,
    @ColumnInfo("street")
    val street: String,
    @ColumnInfo("house")
    val house: String
)