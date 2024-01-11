package com.example.domain.usecases

import com.example.domain.irepos.ICodeRepo
import com.example.domain.models.User
import javax.inject.Inject

class GetCodeUseCase @Inject constructor(
    private val codeRepository: ICodeRepo
) {
    suspend fun getCode(number: String): User{
        return User(
            number,
            codeRepository.getCode(number),
            "no token yet"
        )
    }
}