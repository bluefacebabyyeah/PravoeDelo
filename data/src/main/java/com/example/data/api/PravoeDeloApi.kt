package com.example.data.api

import com.example.data.api.dto.CodeDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PravoeDeloApi {
    @GET("getCode")
    suspend fun getCode(@Query("login") number: String): CodeDto
    @GET("getToken")
    suspend fun getToken(@Query("login")number: String, @Query("password") code: String): String
    @GET("regenerateCode")
    suspend fun getNewCode(@Query("login") number: String): String
    /* @POST("changeCode")
    suspend fun changeCode(code: String): String */
}