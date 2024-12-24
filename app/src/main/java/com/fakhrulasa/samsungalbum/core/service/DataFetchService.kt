package com.fakhrulasa.samsungalbum.core.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.photo.PhotosResponseNetworkItem
import com.fakhrulasa.samsungalbum.data.model.response.user.UserResponseNetworkItem
import com.fakhrulasa.samsungalbum.domain.repository.AlbumRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@AndroidEntryPoint
class DataFetchService : Service() {


    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var albumRepository: AlbumRepository

    suspend fun fetchPhotos(): List<PhotosResponseNetworkItem> =
        albumRepository.fetchPhotosDataFromNetwork()

    suspend fun fetchAlbums(): List<AlbumResponseNetworkItem> =
        albumRepository.fetchAlbumDataFromNetwork()

    suspend fun fetchUsers(): List<UserResponseNetworkItem> =
        albumRepository.fetchUserDataFromNetwork()

    private val binder = LocalBinder()

    // Called when the service is bound
    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    inner class LocalBinder : Binder() {
        fun getService(): DataFetchService = this@DataFetchService
    }
}