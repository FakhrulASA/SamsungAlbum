package com.fakhrulasa.samsungalbum.data.repositoryimpl

import com.fakhrulasa.samsungalbum.core.network.ApiService
import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    AlbumRepository {
    override suspend fun fetchUserDataFromNetwork(): List<User> {
        return apiService.getUser().body()!!
    }

    override suspend fun fetchAlbumDataFromNetwork(): List<Photo> {
        return apiService.getAlbum().body()!!
    }

    override suspend fun fetchPhotosDataFromNetwork(): List<Album> {
        return apiService.getPhoto().body()!!
    }

}