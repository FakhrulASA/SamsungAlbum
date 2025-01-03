package com.fakhrulasa.samsungalbum.domain.usecase

import com.fakhrulasa.samsungalbum.core.base.BaseUseCase
import com.fakhrulasa.samsungalbum.core.base.Resource
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.domain.repository.AlbumRepository
import javax.inject.Inject

class FetchAlbumUseCase @Inject constructor(
    private val albumRepository: AlbumRepository
) : BaseUseCase<Int, List<Album>>() {

    override suspend fun execute(): Resource<List<Album>> {
        return try {
            // Simulate fetching data from the repository
            val album = albumRepository.fetchPhotosDataFromNetwork()
            Resource.Success(album)
        } catch (e: Exception) {
            // Handle any exceptions that occur
            Resource.Error("Error occurred: ${e.message}")
        }
    }
}