package com.task.ecommerce.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.e_commerce_task.databinding.FragmentHomeBinding
import com.example.e_commerce_task.ui.main.SharedViewModel
import com.task.ecommerce.model.Result
import com.task.ecommerce.ui.fragments.home.adapters.ContainerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.getHome()
            viewModel.success.collect { data ->
                try {
                    if (data != null) {
                        setHomeAdapter(data)
                        Log.d("TESTDTAFORHOMEPAGE", "data from home is ${data.toString()}")
                        Toast.makeText(context, "${data.get(1).type}", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.d("TESTDTAFORHOMEPAGE", "data from home is ${data.toString()}")
                    }
                } catch (e: Exception) {
                    Log.d("TESTDTAFORHOMEPAGE", " from home  exc is ${e.toString().toString()}")
                }
            }
        }
    }

    fun setHomeAdapter(results: List<Result>?) {
        binding.rvHomeContainer.adapter = ContainerAdapter(results !!)
    }
}