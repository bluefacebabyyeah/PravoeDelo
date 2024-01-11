package com.example.data.api.repositories

import com.example.data.api.PravoeDeloApi
import com.example.domain.irepos.ICodeRepo
import javax.inject.Inject

class CodeRepository @Inject constructor(
    private val api: PravoeDeloApi
): ICodeRepo {
    override suspend fun getCode(number: String): String {
        return api.getCode(number).code
    }

    override suspend fun regenerateCode(number: String): String {
        return api.getNewCode(number)
    }
}