package com.fakhrulasa.samsungalbum.data.mapper

import com.fakhrulasa.samsungalbum.data.model.response.album.Photo
import com.fakhrulasa.samsungalbum.data.model.response.photo.Album
import com.fakhrulasa.samsungalbum.data.model.response.user.User
import com.fakhrulasa.samsungalbum.view.uidata.AlbumUiModel

fun mapUserAlbumResponseToAlbumUiModel(
    photos: List<Album>,
    albums: List<Photo>,
    users: List<User>
): List<AlbumUiModel> {
    // Create a map of users by their ID for quick lookup
    val userMap = users.associateBy { it.id }

    // Create a map of albums by their ID for quick lookup
    val albumMap = albums.associateBy { it.id }

    // Map the photos to AlbumUiModel
    return photos.mapNotNull { photo ->
        // Find the associated album
        val album = albumMap[photo.albumId] ?: return@mapNotNull null

        // Find the user associated with the album
        val user = userMap[album.userId] ?: return@mapNotNull null

        // Create the AlbumUiModel
        AlbumUiModel(
            albumId = photo.albumId.toString(),
            thumbNail = photo.thumbnailUrl,
            userName = user.name,
            albumName = album.title,
            photoTitle = photo.title
        )
    }.distinctBy { it.albumId }  // Remove duplicates based on albumId
}