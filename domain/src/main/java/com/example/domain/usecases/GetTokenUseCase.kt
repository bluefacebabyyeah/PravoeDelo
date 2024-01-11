package com.example.domain.usecases

import com.example.domain.irepos.ITokenRepo
import com.example.domain.models.User
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val tokenRepository: ITokenRepo
){
    suspend fun getToken(user: User): User{
        return User(
            user.number,
            user.code,
            tokenRepository.getToken(user.number, user.code)
        )
    }
}