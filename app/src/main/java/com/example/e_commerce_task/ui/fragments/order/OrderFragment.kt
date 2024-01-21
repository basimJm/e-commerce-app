package com.task.ecommerce.ui.fragments.order

import OrderImageAdapter
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.e_commerce_task.R
import com.example.e_commerce_task.databinding.FragmentOrderBinding
import com.example.e_commerce_task.ui.main.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OrderFragment : Fragment() {
    private lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: OrderImageAdapter
    private val orderViewModel: SharedViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOrderBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        prepareViewPager()
    }

    private fun prepareViewPager() {
        binding.vpOrder.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicator(position)
            }
        })
    }

    private fun initObserver() {
        lifecycleScope.launch {
            orderViewModel.successItemsById.collect { data ->
                adapter = OrderImageAdapter(data?.image)
                if (data != null) {
                    data.image?.let { createIndicator(it.size) }
                }
                try {
                    if (data != null) {
                        binding.vpOrder.adapter = adapter
                        Log.d("TESTDTAFORHOMEPAGE", "data is ${data.toString()}")
                    }
                } catch (e: Exception) {
                    Log.d("TESTDTAFORHOMEPAGE", "data is null : ${e.message.toString()}")
                }
            }
        }
    }

    private fun createIndicator(count: Int) {
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        // Set margins here (adjust 8dp as needed)
        val marginInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics
        ).toInt()
        layoutParams.setMargins(marginInPixels, 5, marginInPixels, 5)
        for (i in 0 until count) {
            val dot = ImageView(requireContext())
            dot.setImageResource(R.drawable.indicator)
            binding.tabs.addView(dot)
        }
    }

    private fun updateIndicator(position: Int) {
        for (i in 0 until binding.tabs.childCount) {
            val dot = binding.tabs.getChildAt(i) as ImageView
            dot.isSelected = i == position
        }
    }
}