package com.example.headspaceapplication.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.headspaceapplication.extensions.getModelPojo
import com.example.headspaceapplication.extensions.getResponsePojo
import com.example.headspaceapplication.model.PicsumResponse
import com.example.headspaceapplication.repository.PicsumRepository
import com.example.headspaceapplication.repository.local.PageModel
import com.example.headspaceapplication.repository.remote.PicsumService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(
    private val picsumService: PicsumService,
    private val picsumRepository: PicsumRepository
) : ViewModel() {

    val showClear = ObservableField<Boolean>(false)
    var name = MutableLiveData("")

    private val _picsumResponse = MutableLiveData<List<PicsumResponse>>()
    val picsumResponse: LiveData<List<PicsumResponse>>
        get() = _picsumResponse

    fun fetchPictures(page: Int) {
        viewModelScope.launch (Dispatchers.IO){
            val response: List<PicsumResponse>
            if(!checkPageNumber(page.toString())){
                Log.d("TAG","Insert from REST client")
                println("Loading..")
                try {
                    response = picsumService.getPictures(page.toString())
                    _picsumResponse.postValue(response)
                    val modelPictures = getModelPojo(response)
                    picsumRepository.insertPage(PageModel(page.toString()))
                    picsumRepository.insertAll(modelPictures)
                }catch (e: Exception){
                    println(e.message)
                }
            }else{
                Log.d("TAG","Insert from DB")
                response = getResponsePojo(picsumRepository.getAll())
                _picsumResponse.postValue(response)
            }
        }
    }
    suspend fun checkPageNumber(pageNumber: String):Boolean{
        val dbResponse: String = picsumRepository.getPageById(pageNumber)
        Log.d("TAG","PageNumber: $pageNumber, dbResponse: $dbResponse")
        return dbResponse == pageNumber
    }
}