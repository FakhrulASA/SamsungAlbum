package com.fakhrulasa.samsungalbum.core.util

import com.fakhrulasa.samsungalbum.data.mapper.mapUserAlbumResponseToAlbumUiModel
import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.view.uidata.AlbumUiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

fun fetchAndMapData(
    scope: CoroutineScope,
    photosFlow: StateFlow<List<Album>>,
    usersFlow: StateFlow<List<User>>,
    albumFlow: StateFlow<List<Photo>>,
    onResult: (List<AlbumUiModel>?) -> Unit
) {
    scope.launch {
        // Combine the three flows
        combine(photosFlow, usersFlow, albumFlow) { photos, users, albums ->
            Triple(photos, albums, users)
        }.collectLatest { (photos, albums, users) ->
            // Pass the collected data to the mapping method
            val albumUiModel = mapUserAlbumResponseToAlbumUiModel(
                photos = photos,
                albums = albums,
                users = users
            )
            onResult(albumUiModel)
        }
    }
}