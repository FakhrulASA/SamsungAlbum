package com.fakhrulasa.samsungalbum.data.model.response.user

import com.fakhrulasa.samsungalbum.data.model.response.album.AlbumResponseNetworkItem

data class UserResponseNetwork(
    val items : List<UserResponseNetworkItem>
)