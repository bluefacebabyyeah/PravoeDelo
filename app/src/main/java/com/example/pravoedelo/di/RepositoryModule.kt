package com.example.pravoedelo.di

import com.example.data.api.repositories.CodeRepository
import com.example.data.api.repositories.TokenRepository
import com.example.domain.irepos.ICodeRepo
import com.example.domain.irepos.ITokenRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCodeRepo(codeRepo: CodeRepository): ICodeRepo
    @Binds
    abstract fun bindTokenRepo(tokenRepo: TokenRepository): ITokenRepo
}