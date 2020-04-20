package com.example.headspaceapplication.repository.remote

import com.example.headspaceapplication.model.PicsumResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumService {
    @GET("/v2/list")
    suspend fun getPictures(
        @Query("page") page: String
    ): List<PicsumResponse>
}
