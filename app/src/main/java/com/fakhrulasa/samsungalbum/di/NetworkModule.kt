package com.fakhrulasa.samsungalbum.di

import android.content.Context
import com.fakhrulasa.samsungalbum.Application
import com.fakhrulasa.samsungalbum.core.network.ApiService
import com.fakhrulasa.samsungalbum.core.network.RetrofitInstance
import com.fakhrulasa.samsungalbum.data.repositoryimpl.AlbumRepositoryImpl
import com.fakhrulasa.samsungalbum.domain.repository.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideAlbumRepository(apiService: ApiService): AlbumRepository {
        return AlbumRepositoryImpl(apiService)
    }
}