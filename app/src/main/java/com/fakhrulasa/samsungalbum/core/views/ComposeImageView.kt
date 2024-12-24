package com.fakhrulasa.samsungalbum.core.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.fakhrulasa.samsungalbum.R

@Composable
fun ComposeImageView(imageUrl: String, h: Int, w: Int) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .placeholder(R.drawable.loading)
            .error(R.drawable.warning).build()
    )
    Image(
        painter = painter,
        contentDescription = "My Image",
        Modifier
            .height(h.dp)
            .width(w.dp)
            .padding(10.dp)
    )
}