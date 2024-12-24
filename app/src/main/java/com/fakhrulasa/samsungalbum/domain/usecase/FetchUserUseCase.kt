package com.fakhrulasa.samsungalbum.domain.usecase

import com.fakhrulasa.samsungalbum.core.base.BaseUseCase
import com.fakhrulasa.samsungalbum.core.base.Resource
import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.domain.repository.AlbumRepository
import javax.inject.Inject

class FetchUserUseCase @Inject constructor(
    private val albumRepository: AlbumRepository
) : BaseUseCase<Int, List<User>>() {

    override suspend fun execute(): Resource<List<User>> {
        return try {
            // Simulate fetching data from the repository
            val users = albumRepository.fetchUserDataFromNetwork()
            Resource.Success(users)
        } catch (e: Exception) {
            // Handle any exceptions that occur
            Resource.Error("Error occurred: ${e.message}")
        }
    }
}