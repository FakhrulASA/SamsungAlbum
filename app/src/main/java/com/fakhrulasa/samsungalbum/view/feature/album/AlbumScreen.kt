package com.fakhrulasa.samsungalbum.view.feature.album

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.fakhrulasa.samsungalbum.core.views.ComposeImageView
import com.fakhrulasa.samsungalbum.core.views.ContentWithShimmerLoading
import com.fakhrulasa.samsungalbum.view.viewmodel.AlbumViewModel
import com.fakhrulasa.samsungalbum.view.widget.AlbumItemWidget

@Composable
fun AlbumScreen(safePadding:PaddingValues,viewModel: AlbumViewModel = hiltViewModel()) {
    val uiData by viewModel.uiData.collectAsState()
    val errorMessage by viewModel.isError.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.observeAndMapData()
    }
    if(isLoading){
        ContentWithShimmerLoading(safePadding)
    }else if(errorMessage.isEmpty() && uiData.isNotEmpty()){
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(safePadding).background(Color.Black)) {
            items(uiData.size) { position ->
                AlbumItemWidget(uiData[position])
            }
        }
    }else if(errorMessage.isNotEmpty()){
        Toast.makeText(LocalContext.current, "Button clicked!", Toast.LENGTH_SHORT).show()
    }
}