package com.example.pravoedelo.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.models.User
import com.example.pravoedelo.R
import com.example.pravoedelo.databinding.FragmentAuthorizationBinding
import com.example.pravoedelo.ui.user.UserFragment
import com.example.pravoedelo.ui.user.UserFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorizationFragment : Fragment(R.layout.fragment_authorization) {
    private val binding by viewBinding(FragmentAuthorizationBinding::bind)
    private val viewModel by viewModels<AuthorizationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bSubmit.setOnClickListener{
            viewModel.getCode(binding.et.text.toString())
            viewModel.user  .value?.let { it1 -> toUserPage(it1) }
        }
        viewModel.error.observe(viewLifecycleOwner){
            if (it!=null){
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun toUserPage(it: User){
        findNavController().navigate(
            resId = R.id.action_authorizationFragment_to_userFragment,
            args = UserFragmentArgs(it).toBundle()
        )
    }
}