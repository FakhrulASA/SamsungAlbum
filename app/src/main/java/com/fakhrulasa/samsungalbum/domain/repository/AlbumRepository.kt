package com.fakhrulasa.samsungalbum.domain.repository

import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.photo.PhotosResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.user.UserResponseNetworkItem

interface AlbumRepository {
    suspend fun fetchUserDataFromNetwork(): List<UserResponseNetworkItem>
    suspend fun fetchAlbumDataFromNetwork(): List<AlbumResponseNetworkItem>

    suspend fun fetchPhotosDataFromNetwork(): List<PhotosResponseNetworkItem>
}