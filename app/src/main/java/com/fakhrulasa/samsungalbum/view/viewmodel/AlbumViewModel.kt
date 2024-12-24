package com.fakhrulasa.samsungalbum.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fakhrulasa.samsungalbum.core.service.DataFetchService
import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetwork
import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.photo.PhotosResponseNetwork
import com.fakhrulasa.samsungalbum.data.model.response.photo.PhotosResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.user.UserResponseNetwork
import com.fakhrulasa.samsungalbum.data.model.response.user.UserResponseNetworkItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor() : ViewModel() {
    private val _photosFlow = MutableStateFlow<List<PhotosResponseNetworkItem>>(listOf())
    val photosFlow: StateFlow<List<PhotosResponseNetworkItem>> = _photosFlow

    private val _usersFlow = MutableStateFlow<List<UserResponseNetworkItem>>(listOf())
    val usersFlow: StateFlow<List<UserResponseNetworkItem>> = _usersFlow

    private val _albumFlow = MutableStateFlow<List<AlbumResponseNetworkItem>>(listOf())
    val albumFlow: StateFlow<List<AlbumResponseNetworkItem>> = _albumFlow


    // Function to update photos
    fun fetchData(service: DataFetchService){
        CoroutineScope(Dispatchers.IO).launch {
            service.let { service ->
                _albumFlow.value=service.fetchAlbums()
            }
        }
    }
}