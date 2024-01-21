package com.task.ecommerce.ui.fragments.checkout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.e_commerce_task.databinding.FragmentCheckoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckoutFragment : Fragment() {
    private lateinit var binding: FragmentCheckoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCheckoutBinding.inflate(layoutInflater)
        return binding.root
    }
}