package com.example.headspaceapplication.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PageModel::class, PicsumModel::class], version = 5)
abstract class PicsumDatabase : RoomDatabase(){
    abstract fun picsumDao(): PicsumDao
    abstract fun pageDao(): PageDao
}