package com.example.headspaceapplication.repository

import androidx.lifecycle.LiveData
import com.example.headspaceapplication.model.PicsumResponse
import com.example.headspaceapplication.repository.local.PageDao
import com.example.headspaceapplication.repository.local.PageModel
import com.example.headspaceapplication.repository.local.PicsumDao
import com.example.headspaceapplication.repository.local.PicsumModel
import org.jetbrains.annotations.NotNull
import javax.inject.Inject

class PicsumRepository @Inject constructor(
    private val picsumDao: PicsumDao,
    private val pageDao: PageDao
){

    suspend fun getAll(): List<PicsumModel> = picsumDao.getAll()

    suspend fun  insertAll(models: List<PicsumModel>) = picsumDao.insertAll(models)

    suspend fun  getById(modelId: String): PicsumModel = picsumDao.getById(modelId)

    suspend fun insert(model: PicsumModel) = picsumDao.insert(model)

    suspend fun getPageById(page: String) = pageDao.getPage(page)

    suspend fun insertPage(page: PageModel) = pageDao.insertPage(page)
}