package com.fakhrulasa.samsungalbum.core.service

import android.app.Service
import android.app.Service.START_STICKY
import android.content.Intent
import android.os.IBinder
import com.fakhrulasa.samsungalbum.core.network.RetrofitInstance
import com.fakhrulasa.samsungalbum.view.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DataFetchService : Service() {


    private val coroutineScope = CoroutineScope(Dispatchers.IO)


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        coroutineScope.launch {
            fetchData()
        }
        return START_STICKY // This ensures the service is restarted if it gets killed
    }
    private suspend fun fetchData() {
        try {
            val apiService = RetrofitInstance.apiService
            val photos = apiService.getPhoto()
            val users = apiService.getUser()
            val albums = apiService.getAlbum()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}