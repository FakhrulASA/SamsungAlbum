package com.fakhrulasa.samsungalbum.di

import android.content.Context
import com.fakhrulasa.samsungalbum.Application
import com.fakhrulasa.samsungalbum.core.network.ApiService
import com.fakhrulasa.samsungalbum.core.network.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitInstance.apiService
    }
}