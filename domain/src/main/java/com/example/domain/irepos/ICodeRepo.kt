package com.example.domain.irepos

interface ICodeRepo {
    suspend fun getCode(number: String): String
    suspend fun regenerateCode(number: String): String
}