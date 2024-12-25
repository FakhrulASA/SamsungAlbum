package com.fakhrulasa.samsungalbum

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.fakhrulasa.samsungalbum.core.service.DataFetchService
import com.fakhrulasa.samsungalbum.ui.theme.SamsungAlbumTheme
import com.fakhrulasa.samsungalbum.view.feature.album.AlbumScreen
import com.fakhrulasa.samsungalbum.view.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: AlbumViewModel by viewModels()
    private var photoService: DataFetchService? = null
    private var isBound = false

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SamsungAlbumTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Samsung Album", style = TextStyle(fontSize = 26.sp))
                            }
                        )
                    }
                ) { innerPadding ->
                    AlbumScreen(innerPadding)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, DataFetchService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as DataFetchService.LocalBinder
            photoService = binder.getService()
            isBound = true
            photoService?.let { viewModel.fetchData(it) }

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }
    }

    override fun onStop() {
        super.onStop()
        if (isBound) {
            //it will prevent memory licking
            unbindService(serviceConnection)
            isBound = false
        }
    }

}
