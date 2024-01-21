package com.task.ecommerce.ui.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.e_commerce_task.databinding.RowSectionBinding
import com.task.ecommerce.model.Data

class SectionsRecyclerAdapter(val list: List<Data>) : RecyclerView.Adapter<SectionsRecyclerAdapter.SectionViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SectionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SectionViewHolder(RowSectionBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class SectionViewHolder(private val binding: RowSectionBinding) : ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.data = data
        }
    }
}
