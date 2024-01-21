package com.task.ecommerce.ui.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.e_commerce_task.R
import com.example.e_commerce_task.databinding.RowPagerDotBinding

class DotsRecyclerAdapter(private val size: Int) : RecyclerView.Adapter<DotsRecyclerAdapter.DotsViewHolder>() {
    var selectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DotsViewHolder {
        return DotsViewHolder(RowPagerDotBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: DotsViewHolder, position: Int) {
        if (position == selectedPosition) {
            holder.binding.root.setBackgroundResource(R.drawable.shape_dot_selected)
        } else {
            holder.binding.root.setBackgroundResource(R.drawable.shape_dot_unselected)
        }
    }

    fun setSelected(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

    inner class DotsViewHolder(val binding: RowPagerDotBinding) : ViewHolder(binding.root) {
    }
}
