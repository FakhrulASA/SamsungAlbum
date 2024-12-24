package com.fakhrulasa.samsungalbum.core.network

import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetwork
import com.fakhrulasa.samsungalbum.data.model.response.photo.PhotosResponseNetwork
import com.fakhrulasa.samsungalbum.data.model.response.user.UserResponseNetwork
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPhoto(): Response<PhotosResponseNetwork>

    @GET("users")
    suspend fun getUser(): Response<UserResponseNetwork>

    @GET("albums")
    suspend fun getAlbum(): Response<AlbumResponseNetwork>
}