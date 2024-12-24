package com.fakhrulasa.samsungalbum.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fakhrulasa.samsungalbum.core.service.DataFetchService
import com.fakhrulasa.samsungalbum.core.util.fetchAndMapData
import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.view.uidata.AlbumUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor() : ViewModel() {
    private val _photosFlow = MutableStateFlow<List<Album>>(listOf())
    val photosFlow: StateFlow<List<Album>> = _photosFlow

    private val _usersFlow = MutableStateFlow<List<User>>(listOf())
    val usersFlow: StateFlow<List<User>> = _usersFlow

    private val _albumFlow = MutableStateFlow<List<Photo>>(listOf())
    val albumFlow: StateFlow<List<Photo>> = _albumFlow

    private val _uiData = MutableStateFlow<List<AlbumUiModel>>(listOf())
    val uiData: StateFlow<List<AlbumUiModel>> = _uiData

    // Function to update photos
    fun fetchData(service: DataFetchService){
        CoroutineScope(Dispatchers.IO).launch {
            service.let { service ->
                _albumFlow.value=service.fetchAlbums()
                _usersFlow.value=service.fetchUsers()
                _photosFlow.value=service.fetchPhotos()
            }
        }
    }

    fun observeAndMapData() {
        fetchAndMapData(viewModelScope, photosFlow, usersFlow, albumFlow){
            _uiData.value = it!!
        }
    }
}