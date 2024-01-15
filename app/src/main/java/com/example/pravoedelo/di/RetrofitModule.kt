package com.example.pravoedelo.di

import com.example.data.api.PravoeDeloApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    fun provideApi(): PravoeDeloApi =
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(PravoeDeloApi::class.java)
}