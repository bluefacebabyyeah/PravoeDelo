package com.example.data.api.repositories

import android.content.Context
import android.widget.Toast
import com.example.data.api.PravoeDeloApi
import com.example.domain.irepos.ITokenRepo
import javax.inject.Inject

class TokenRepository @Inject constructor(
    private val api: PravoeDeloApi
) : ITokenRepo {
    override suspend fun getToken(number: String, code: String): String{
        if (api.getToken(number,code) is String) return api.getToken(number, code).toString()
        return "Error"
    }
}