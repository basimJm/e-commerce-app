package com.task.ecommerce.ui.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_task.databinding.RowOfferBinding
import com.task.ecommerce.model.Data

class OfferPagerAdapter(private val list: List<Data>) :
    RecyclerView.Adapter<OfferPagerAdapter.OfferViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OfferViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OfferViewHolder(RowOfferBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OfferViewHolder(private val binding: RowOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.data = data
        }
    }
}