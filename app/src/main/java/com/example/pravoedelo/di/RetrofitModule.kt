package com.example.pravoedelo.di

import com.example.data.api.PravoeDeloApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    companion object {
        const val API_URL = "https://lk.pravoe-delo.su/api/v1/"
    }
    @Provides
    fun provideApi() =
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PravoeDeloApi::class.java)
}