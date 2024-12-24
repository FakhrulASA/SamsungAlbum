package com.fakhrulasa.samsungalbum.core.network

import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.photo.PhotosResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.user.UserResponseNetworkItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPhoto(): Response<List<PhotosResponseNetworkItem>>

    @GET("users")
    suspend fun getUser(): Response<List<UserResponseNetworkItem>>

    @GET("albums")
    suspend fun getAlbum(): Response<List<AlbumResponseNetworkItem>>
}