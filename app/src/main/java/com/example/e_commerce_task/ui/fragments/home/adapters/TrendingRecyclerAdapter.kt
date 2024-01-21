package com.task.ecommerce.ui.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_task.databinding.RowTrendingBinding
import com.task.ecommerce.model.Data

class TrendingRecyclerAdapter(val list: List<Data>) : RecyclerView.Adapter<TrendingRecyclerAdapter.TrendingViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrendingViewHolder(RowTrendingBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TrendingViewHolder(private val binding: RowTrendingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.data = data
        }
    }
}