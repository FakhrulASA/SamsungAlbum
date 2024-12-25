package com.fakhrulasa.samsungalbum.domain.repository

import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User

interface AlbumRepository {
    suspend fun fetchUserDataFromNetwork(): List<User>
    suspend fun fetchAlbumDataFromNetwork(): List<Photo>
    suspend fun fetchPhotosDataFromNetwork(): List<Album>
}