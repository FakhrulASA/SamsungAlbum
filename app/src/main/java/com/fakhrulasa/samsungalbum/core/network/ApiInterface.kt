package com.fakhrulasa.samsungalbum.core.network

import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPhoto(): Response<List<Album>>

    @GET("users")
    suspend fun getUser(): Response<List<User>>

    @GET("albums")
    suspend fun getAlbum(): Response<List<Photo>>
}