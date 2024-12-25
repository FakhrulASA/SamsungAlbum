package com.fakhrulasa.samsungalbum.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fakhrulasa.samsungalbum.core.base.Resource
import com.fakhrulasa.samsungalbum.core.service.DataFetchService
import com.fakhrulasa.samsungalbum.core.util.fetchAndMapData
import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.view.uidata.AlbumUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class AlbumViewModel @Inject constructor() : ViewModel() {
    private val _photosFlow = MutableStateFlow<List<Album>>(listOf())
    val photosFlow: StateFlow<List<Album>> = _photosFlow

    private val _usersFlow = MutableStateFlow<List<User>>(listOf())
    val usersFlow: StateFlow<List<User>> = _usersFlow

    private val _albumFlow = MutableStateFlow<List<Photo>>(listOf())
    val albumFlow: StateFlow<List<Photo>> = _albumFlow

    private val _uiData = MutableStateFlow<List<AlbumUiModel>>(listOf())
    open val uiData: StateFlow<List<AlbumUiModel>> = _uiData

    private val _isLoading = MutableStateFlow(false)
    open val isLoading: StateFlow<Boolean> = _isLoading

    private val _isError = MutableStateFlow("")
    open val isError: StateFlow<String> = _isError

    // Function to update photos
    fun fetchData(service: DataFetchService) {
        viewModelScope.launch(Dispatchers.IO) {
            // Show loading spinner before starting
            _isLoading.value = true

            // Async calls to fetch data concurrently
            val albumsDeferred = async { service.fetchAlbums() }
            val photosDeferred = async { service.fetchPhotos() }
            val usersDeferred = async { service.fetchUsers() }

            // Wait for all the async tasks to complete
            val results = awaitAll(albumsDeferred, photosDeferred, usersDeferred)

            // Process the results and update the UI state
            val albumResult = results[0]
            val photoResult = results[1]
            val userResult = results[2]

            // Handle albums result
            when (albumResult) {
                is Resource.Loading -> {
                    //Ignore
                }

                is Resource.Success -> {
                    _albumFlow.value = albumResult.data as List<Photo>
                }

                is Resource.Error -> {
                    _isError.value = albumResult.message
                }
            }

            // Handle photos result
            when (photoResult) {
                is Resource.Loading -> {
                    //Ignore
                }

                is Resource.Success -> {
                    _photosFlow.value = photoResult.data as List<Album>
                }

                is Resource.Error -> {
                    _isError.value = photoResult.message
                }
            }

            // Handle users result
            when (userResult) {
                is Resource.Loading -> {
                    //Ignore
                }

                is Resource.Success -> {
                    _usersFlow.value = userResult.data as List<User>
                }

                is Resource.Error -> {
                    _isError.value = userResult.message
                }
            }

            // Set loading to false after all tasks are completed
            _isLoading.value = false
        }
    }

    fun observeAndMapData() {
        fetchAndMapData(viewModelScope, photosFlow, usersFlow, albumFlow) {
            _uiData.value = it!!
        }
    }
}