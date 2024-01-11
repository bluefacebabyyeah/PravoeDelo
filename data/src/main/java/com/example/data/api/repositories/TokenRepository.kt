package com.example.data.api.repositories

import com.example.data.api.PravoeDeloApi
import com.example.domain.irepos.ITokenRepo
import javax.inject.Inject

class TokenRepository @Inject constructor(
    private val api: PravoeDeloApi
) : ITokenRepo {
    override suspend fun getToken(number: String, code: String): String{
        return api.getToken(number, code)
    }
}