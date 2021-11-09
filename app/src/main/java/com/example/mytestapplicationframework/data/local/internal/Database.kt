package com.example.mytestapplicationframework.data.local.internal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytestapplicationframework.data.Entity
import com.example.mytestapplicationframework.data.local.Dao

@Database(entities = [Entity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun getDao(): Dao
}