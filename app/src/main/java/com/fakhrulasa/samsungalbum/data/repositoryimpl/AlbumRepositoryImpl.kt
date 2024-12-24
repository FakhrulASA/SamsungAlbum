package com.fakhrulasa.samsungalbum.data.repositoryimpl

import com.fakhrulasa.samsungalbum.core.network.ApiService
import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.photo.PhotosResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.user.UserResponseNetworkItem
import com.fakhrulasa.samsungalbum.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    AlbumRepository {
    override suspend fun fetchUserDataFromNetwork(): List<UserResponseNetworkItem> {
        return apiService.getUser().body()!!
    }

    override suspend fun fetchAlbumDataFromNetwork(): List<AlbumResponseNetworkItem> {
        return apiService.getAlbum().body()!!
    }

    override suspend fun fetchPhotosDataFromNetwork(): List<PhotosResponseNetworkItem> {
        return apiService.getPhoto().body()!!
    }

}