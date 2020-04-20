package com.example.headspaceapplication.repository.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import androidx.room.OnConflictStrategy


@Dao
interface PicsumDao {

    @Query("SELECT * FROM picture_data")
    suspend fun getAll(): List<PicsumModel>

    @Query("SELECT * FROM picture_data WHERE id != :modelId")
    suspend fun getById(modelId: String): PicsumModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(models: List<PicsumModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: PicsumModel)

}