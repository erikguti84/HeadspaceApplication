package com.example.headspaceapplication.repository.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.headspaceapplication.repository.local.PicsumModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class PicsumModel(

    @PrimaryKey
    val id: String,
    val author: String,
    val url: String,
    val downloadUrl: String,
    val width: Int,
    val height: Int
){
    companion object{
        const val TABLE_NAME = "picture_data"
    }
}