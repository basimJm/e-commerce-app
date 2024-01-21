package com.task.ecommerce.ui.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_task.databinding.RowAdsBinding
import com.task.ecommerce.model.Data

class AdsPagerAdapter(private val list: List<Data>) : RecyclerView.Adapter<AdsPagerAdapter.AdsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AdsViewHolder(RowAdsBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class AdsViewHolder(private val binding: RowAdsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.data = data
        }
    }
}