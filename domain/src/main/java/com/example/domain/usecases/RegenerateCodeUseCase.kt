package com.example.domain.usecases

import com.example.domain.irepos.ICodeRepo
import com.example.domain.models.User
import javax.inject.Inject

class RegenerateCodeUseCase @Inject constructor(
    private val codeRepository: ICodeRepo
) {
    suspend fun regenerateCode(user: User): User {
        return User(
            user.number,
            codeRepository.regenerateCode(user.number),
            "no token yet"
        )
    }
}