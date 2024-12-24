package com.fakhrulasa.samsungalbum.domain.usecase

import com.fakhrulasa.samsungalbum.core.base.BaseUseCase
import com.fakhrulasa.samsungalbum.core.base.Resource
import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.domain.repository.AlbumRepository
import javax.inject.Inject

class FetchPhotosUseCase @Inject constructor(
    private val albumRepository: AlbumRepository
) : BaseUseCase<Int, List<Photo>>() {

    override suspend fun execute(): Resource<List<Photo>> {
        return try {
            // Simulate fetching data from the repository
            val photos = albumRepository.fetchAlbumDataFromNetwork()
            Resource.Success(photos)
        } catch (e: Exception) {
            // Handle any exceptions that occur
            Resource.Error("Error occurred: ${e.message}")
        }
    }
}