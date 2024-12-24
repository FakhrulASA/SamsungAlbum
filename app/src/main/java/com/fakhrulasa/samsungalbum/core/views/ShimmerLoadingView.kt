package com.fakhrulasa.samsungalbum.core.views

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

@Composable
fun ShimmerPlaceholder(modifier: Modifier = Modifier) {
    // Create shimmer effect using a LinearGradient
    val transition = rememberInfiniteTransition()

    // Define an animated offset for the shimmer movement
    val shimmerOffset by transition.animateFloat(
        initialValue = -1f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    // Define a LinearGradient for shimmer effect
    val shimmerBrush = Brush.linearGradient(
        colors = listOf(Color.Gray, Color.LightGray, Color.Gray),
        start = Offset(shimmerOffset * 1000f, 0f), // Animate the offset
        end = Offset(shimmerOffset * 1000f + 1000f, 0f)
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(shimmerBrush) // Apply shimmer effect as background
    )
}

@Composable
fun ContentWithShimmerLoading(safePadding:PaddingValues) {
    Column(modifier = Modifier.fillMaxSize().padding(safePadding).background(Color.Black)) {
        // Shimmer Placeholder
        ShimmerPlaceholder(modifier = Modifier.padding(16.dp))
        ShimmerPlaceholder(modifier = Modifier.padding(16.dp))
        ShimmerPlaceholder(modifier = Modifier.padding(16.dp))
        ShimmerPlaceholder(modifier = Modifier.padding(16.dp))
        ShimmerPlaceholder(modifier = Modifier.padding(16.dp))
    }
}