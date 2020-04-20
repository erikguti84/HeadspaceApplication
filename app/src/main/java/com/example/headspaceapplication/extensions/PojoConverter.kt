package com.example.headspaceapplication.extensions

import androidx.lifecycle.LiveData
import com.example.headspaceapplication.model.PicsumResponse
import com.example.headspaceapplication.repository.local.PicsumModel

fun getModelPojo(picsumResponse: List<PicsumResponse>): List<PicsumModel>{
    val picsumList = mutableListOf<PicsumModel>()
    for(i in picsumResponse.indices){
        picsumList.add(
            PicsumModel(
                picsumResponse.get(i).id,
                picsumResponse.get(i).author,
                picsumResponse.get(i).url,
                picsumResponse.get(i).downloadUrl,
                picsumResponse.get(i).width,
                picsumResponse.get(i).height

        ))
    }
    return picsumList
}
fun getResponsePojo(picsumModel: List<PicsumModel>): List<PicsumResponse>{
    val picsumList = mutableListOf<PicsumResponse>()
    for(i in picsumModel.indices){
        picsumList.add(
            PicsumResponse(

                picsumModel.get(i).author,
                picsumModel.get(i).width,
                picsumModel.get(i).downloadUrl,
                picsumModel.get(i).id,
                picsumModel.get(i).url,
                picsumModel.get(i).height

            )
        )
    }
    return picsumList
}