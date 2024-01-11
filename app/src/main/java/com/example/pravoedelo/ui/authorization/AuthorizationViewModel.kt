package com.example.pravoedelo.ui.authorization

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.User
import com.example.domain.usecases.GetCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val getCodeUseCase: GetCodeUseCase
) : ViewModel() {

    val error = MutableLiveData<String?>()
    val user = MutableLiveData<User>()

    fun getCode(number: String){
        viewModelScope.launch {
            try {
                user.value = getCodeUseCase.getCode(number)
            } catch (e : Exception) {
                error.value = e.message
                error.value = null
            }
        }
    }
}