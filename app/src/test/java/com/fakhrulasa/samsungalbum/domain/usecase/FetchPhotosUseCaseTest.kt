package com.fakhrulasa.samsungalbum.domain.usecase

import com.fakhrulasa.samsungalbum.core.base.Resource
import com.fakhrulasa.samsungalbum.data.mock.mockAlbums
import com.fakhrulasa.samsungalbum.data.mock.mockPhotos
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.domain.repository.AlbumRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test

class FetchPhotosUseCaseTest {

    private lateinit var fetchPhotosUseCase: FetchPhotosUseCase
    private val mockAlbumRepository: AlbumRepository = mockk() // Define mock repository

    @Before
    fun setUp() {
        // Initialize the FetchAlbumUseCase with the mocked AlbumRepository
        fetchPhotosUseCase = FetchPhotosUseCase(mockAlbumRepository)
    }

    @Test
    fun `execute should return success when repository fetches albums successfully`() = runTest {
        // Arrange
        val mockPhoto = mockPhotos
        coEvery { mockAlbumRepository.fetchAlbumDataFromNetwork() } returns mockPhotos

        // Act
        val result = fetchPhotosUseCase.execute()

        // Assert
        assertEquals(Resource.Success(mockPhoto), result)
    }

    @Test
    fun `execute should return error when repository throws an exception`() = runTest {
        // Arrange
        val exceptionMessage = "Network error"
        coEvery { mockAlbumRepository.fetchAlbumDataFromNetwork() } throws RuntimeException(exceptionMessage)

        // Act
        val result = fetchPhotosUseCase.execute()

        // Assert
        assertEquals(Resource.Error("Error occurred: $exceptionMessage"), result)
    }
}