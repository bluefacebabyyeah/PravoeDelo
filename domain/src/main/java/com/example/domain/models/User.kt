package com.example.domain.models

import java.io.Serializable

data class User(
    val number: String,
    val code: String,
    val token: String
) : Serializable