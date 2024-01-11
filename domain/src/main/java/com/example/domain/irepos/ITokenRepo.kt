package com.example.domain.irepos

interface ITokenRepo {
    suspend fun getToken(number: String, code: String): String
}