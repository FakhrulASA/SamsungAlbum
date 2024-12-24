package com.fakhrulasa.samsungalbum.domain.repository

interface AlbumRepository {
    fun fetchUserDataFromNetwork()
    fun fetchAlbumDataFromNetwork()
}