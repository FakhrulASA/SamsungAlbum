package com.fakhrulasa.samsungalbum.data.mapper

import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.view.uidata.AlbumUiModel

fun mapUserAlbumResponseToAlbumUiModel(
    photos: List<Album>,
    albums: List<Photo>,
    users: List<User>
): AlbumUiModel? {
    return null
}