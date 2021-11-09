package com.example.mytestapplicationframework.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mytestapplicationframework.data.Entity

@androidx.room.Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg entities: Entity)

    @Delete
    fun delete(vararg entities: Entity)

    @Update
    fun update(vararg entities: Entity)

    @Query("SELECT * FROM Entities")
    fun getEntities(): List<Entity>

    @Query("SELECT * FROM Entities WHERE id = :id")
    fun getEntity(id: String?): Entity

    @Query("SELECT * FROM Entities")
    fun observeEntities(): LiveData<List<Entity>>

    @Query("SELECT * FROM Entities WHERE id = :id")
    fun observeEntity(id: String?): LiveData<Entity>

}