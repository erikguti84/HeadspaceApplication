package com.example.headspaceapplication.repository.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.headspaceapplication.repository.local.PageModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class PageModel(
    @PrimaryKey
    val id:String
){
    companion object{
        const val TABLE_NAME = "page_table"
    }
}