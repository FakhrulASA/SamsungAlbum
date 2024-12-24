package com.fakhrulasa.samsungalbum.core.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp
import com.facebook.shimmer.Shimmer

@Composable
fun ShimmerPlaceholder(modifier: Modifier = Modifier) {
    val shimmer = Shimmer.AlphaHighlightBuilder().setBaseAlpha(0.3f).setHighlightAlpha(0.6f).build()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Brush.linearGradient(listOf(Color.Gray, Color.LightGray, Color.Gray)))
    )
}

@Composable
fun ContentWithShimmerLoading() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Shimmer Placeholder
        ShimmerPlaceholder(modifier = Modifier.padding(16.dp))

        // Placeholder for text or image
        ShimmerPlaceholder(modifier = Modifier.padding(16.dp).height(60.dp))

        // Placeholder for circular shimmer
        Box(
            modifier = Modifier
                .background(Color.Gray, shape = CircleShape).size(50.dp)
        )
    }
}