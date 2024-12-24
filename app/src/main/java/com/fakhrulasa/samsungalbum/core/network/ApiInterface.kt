package com.fakhrulasa.samsungalbum.core.network

import com.fakhrulasa.samsungalbum.data.model.response.AlbumResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("endpoint")
    suspend fun getData(
        @Query("param1") param1: String,
        @Query("param2") param2: Int
    ): Response<List<AlbumResponse>>
}