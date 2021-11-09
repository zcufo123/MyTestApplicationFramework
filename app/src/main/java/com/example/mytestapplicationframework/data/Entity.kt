package com.example.mytestapplicationframework.data

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@androidx.room.Entity(tableName = "Entities")
data class Entity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String)
