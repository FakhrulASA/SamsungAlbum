package com.fakhrulasa.samsungalbum.core.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.fakhrulasa.samsungalbum.core.base.Resource
import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.domain.usecase.FetchAlbumUseCase
import com.fakhrulasa.samsungalbum.domain.usecase.FetchPhotosUseCase
import com.fakhrulasa.samsungalbum.domain.usecase.FetchUserUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DataFetchService : Service() {
    @Inject
    lateinit var fetchUserUseCase: FetchUserUseCase

    @Inject
    lateinit var fetchAlbumUseCase: FetchAlbumUseCase

    @Inject
    lateinit var fetchPhotosUseCase: FetchPhotosUseCase

    suspend fun fetchPhotos(): Resource<List<Album>> {
        return fetchAlbumUseCase.execute()
    }


    suspend fun fetchAlbums(): Resource<List<Photo>> {
        return fetchPhotosUseCase.execute()
    }

    suspend fun fetchUsers(): Resource<List<User>> {
        return fetchUserUseCase.execute()
    }

    private val binder = LocalBinder()

    // Called when the service is bound
    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    inner class LocalBinder : Binder() {
        fun getService(): DataFetchService = this@DataFetchService
    }
}