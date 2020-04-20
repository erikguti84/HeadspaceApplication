package com.example.headspaceapplication.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PageDao {

    @Query("SELECT * FROM  page_table WHERE id = :page")
    suspend fun getPage(page: String): String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPage(page: PageModel)

}