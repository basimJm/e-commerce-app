package com.task.ecommerce.data.di

import com.task.ecommerce.data.datasource.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {
    @Provides
    @Singleton
    fun provideDataSource(retrofit: Retrofit): ApiServices {
        return retrofit.create()
    }
}