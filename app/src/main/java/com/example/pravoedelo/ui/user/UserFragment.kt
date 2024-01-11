package com.example.pravoedelo.ui.user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pravoedelo.R
import com.example.pravoedelo.databinding.FragmentUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : Fragment(R.layout.fragment_user) {
    private val binding by viewBinding(FragmentUserBinding::bind)
    private val viewModel by viewModels<UserViewModel>()
    private val args by navArgs<UserFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.user.value = args.User
        Toast.makeText(requireContext(), viewModel.user.value!!.number, Toast.LENGTH_LONG).show()
        Toast.makeText(requireContext(), viewModel.user.value!!.code, Toast.LENGTH_LONG).show()
        Toast.makeText(requireContext(), viewModel.user.value!!.token, Toast.LENGTH_LONG).show()
        binding.tvNumber.text = viewModel.user.value!!.number

        binding.bSumbit.setOnClickListener{
            if (binding.et.text.toString() != viewModel.user.value!!.code) {
                Toast.makeText(requireContext(), "Неверный код", Toast.LENGTH_SHORT).show()
                binding.bRegenerate.isVisible = true
            }
            else {
                viewModel.getToken()
                binding.tvToken.isVisible = true
                Toast.makeText(requireContext(), "Здравствуйте, ${viewModel.user.value!!.number.toString()}, Ваш токен: ${viewModel.user.value!!.token}", Toast.LENGTH_LONG).show()
            }
        }

        binding.bRegenerate.setOnClickListener{
            viewModel.regenerateCode()
        }

    }
}