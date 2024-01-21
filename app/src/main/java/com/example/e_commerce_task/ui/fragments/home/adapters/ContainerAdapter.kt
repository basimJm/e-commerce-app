package com.task.ecommerce.ui.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager2.widget.ViewPager2
import com.example.e_commerce_task.databinding.RowAdsContainerBinding
import com.example.e_commerce_task.databinding.RowOfferContainerBinding
import com.example.e_commerce_task.databinding.RowSectionContainerBinding
import com.example.e_commerce_task.databinding.RowTrendingContainerBinding
import com.task.ecommerce.model.Result

class ContainerAdapter(private val results: List<Result>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val ADS_TYPE = 1
        private const val SECTIONS_TYPE = 2
        private const val OFFER_TYPE = 3
        private const val TRENDING_TYPE = 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            ADS_TYPE -> {
                return AdsViewHolder(RowAdsContainerBinding.inflate(inflater, parent, false))
            }

            SECTIONS_TYPE -> {
                return SectionsViewHolder(
                    RowSectionContainerBinding.inflate(
                        inflater,
                        parent,
                        false
                    )
                )
            }

            OFFER_TYPE -> {
                return OffersViewHolder(RowOfferContainerBinding.inflate(inflater, parent, false))
            }

            TRENDING_TYPE -> {
                return TrendingViewHolder(
                    RowTrendingContainerBinding.inflate(
                        inflater,
                        parent,
                        false
                    )
                )
            }

            else -> throw IllegalArgumentException("Unknown viewType1: $viewType")
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (results[position].type) {
            ADS_TYPE -> {
                (holder as AdsViewHolder).bindAds(results[position])
            }

            SECTIONS_TYPE -> {
                (holder as SectionsViewHolder).bindSections(results[position])
            }

            OFFER_TYPE -> {
                (holder as OffersViewHolder).bindOffers(results[position])
            }

            TRENDING_TYPE -> {
                (holder as TrendingViewHolder).bindTrending(results[position])
            }

            else -> throw IllegalArgumentException("Unknown viewType2: ${results[position].type}")
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (results[position].type) {
            ADS_TYPE -> {
                return ADS_TYPE
            }

            SECTIONS_TYPE -> {
                return SECTIONS_TYPE
            }

            OFFER_TYPE -> {
                return OFFER_TYPE
            }

            TRENDING_TYPE -> {
                return TRENDING_TYPE
            }

            else -> throw IllegalArgumentException("Unknown viewType3: ${results[position].type.toString()}")
        }
    }

    inner class AdsViewHolder(private val binding: RowAdsContainerBinding) :
        ViewHolder(binding.root) {
        fun bindAds(result: Result) {
            binding.data = result
            binding.vpAds.adapter = AdsPagerAdapter(result.data !!)
        }
    }

    inner class SectionsViewHolder(private val binding: RowSectionContainerBinding) :
        ViewHolder(binding.root) {
        fun bindSections(result: Result) {
            binding.data = result
            binding.rvSections.adapter = SectionsRecyclerAdapter(result.data !!)
        }
    }

    inner class OffersViewHolder(private val binding: RowOfferContainerBinding) :
        ViewHolder(binding.root) {
        fun bindOffers(result: Result) {
            binding.data = result
            binding.vpOfferContainer.adapter = OfferPagerAdapter(result.data !!)
            val indicatorAdapter = DotsRecyclerAdapter(result.data.size)
            binding.rvDots.adapter = indicatorAdapter
            binding.vpOfferContainer.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    indicatorAdapter.setSelected(position)
                }
            })
        }
    }

    inner class TrendingViewHolder(private val binding: RowTrendingContainerBinding) :
        ViewHolder(binding.root) {
        fun bindTrending(result: Result) {
            binding.data = result
            binding.rvTrending.adapter = TrendingRecyclerAdapter(result.data !!)
        }
    }
}