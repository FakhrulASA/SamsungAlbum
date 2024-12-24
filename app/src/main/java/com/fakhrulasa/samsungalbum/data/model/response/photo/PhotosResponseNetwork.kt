package com.fakhrulasa.samsungalbum.data.model.response.photo

import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetworkItem

data class PhotosResponseNetwork(
    val items : List<PhotosResponseNetworkItem>
)