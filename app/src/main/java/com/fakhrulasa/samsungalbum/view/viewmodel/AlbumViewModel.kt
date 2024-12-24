package com.fakhrulasa.samsungalbum.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetwork
import com.fakhrulasa.samsungalbum.data.model.response.photo.PhotosResponseNetwork
import com.fakhrulasa.samsungalbum.data.model.response.user.UserResponseNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor() : ViewModel() {
    private val _photosFlow = MutableStateFlow<PhotosResponseNetwork>(PhotosResponseNetwork())
    val photosFlow: StateFlow<PhotosResponseNetwork> = _photosFlow

    private val _usersFlow = MutableStateFlow<UserResponseNetwork>(UserResponseNetwork())
    val usersFlow: StateFlow<UserResponseNetwork> = _usersFlow

    private val _albumFlow = MutableStateFlow<AlbumResponseNetwork>(AlbumResponseNetwork())
    val albumFlow: StateFlow<AlbumResponseNetwork> = _albumFlow


    // Function to update photos
    fun setPhotos(photos: Response<PhotosResponseNetwork>) {
        _photosFlow.value = photos.body()!!
    }
    fun setAlbum(album : Response<AlbumResponseNetwork>) {
        _albumFlow.value = album.body()!!
    }
    fun setUser(user: Response<UserResponseNetwork>) {
        _usersFlow.value = user.body()!!
    }
}