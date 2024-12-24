package com.fakhrulasa.samsungalbum.data.model.response.photo

data class PhotosResponseNetworkItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)