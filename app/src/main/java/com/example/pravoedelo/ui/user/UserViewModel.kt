package com.example.pravoedelo.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.User
import com.example.domain.usecases.GetTokenUseCase
import com.example.domain.usecases.RegenerateCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val regenerateCodeUseCase: RegenerateCodeUseCase
): ViewModel() {
    val error = MutableLiveData<String?>()
    val user = MutableLiveData<User>()

    fun getToken(){
        viewModelScope.launch {
            try {
                user.value = getTokenUseCase.getToken(user.value!!)
            } catch (e: Exception) {
                error.value = e.message
                error.value = null
            }

        }
    }

    fun regenerateCode(){
        viewModelScope.launch {
            try {
                user.value = regenerateCodeUseCase.regenerateCode(user.value!!)
            } catch (e: Exception) {
                error.value = e.message
                error.value = null
            }
        }
    }
}