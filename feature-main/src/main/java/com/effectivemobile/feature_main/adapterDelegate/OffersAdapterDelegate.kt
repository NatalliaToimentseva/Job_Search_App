package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.databinding.OffersSectionBinding
import com.effectivemobile.feature_main.models.MainScreenViews
import com.effectivemobile.feature_main.rececleView.offers.OffersAdapter
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class OffersAdapterDelegate(
    private val onClick: (link: String) -> Unit
) : AdapterDelegate<List<MainScreenViews>>() {

    override fun isForViewType(items: List<MainScreenViews>, position: Int): Boolean {
        return items[position] is MainScreenViews.OffersSection
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(
            OffersSectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        items: List<MainScreenViews>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as ViewHolder).bind(items[position] as MainScreenViews.OffersSection)
    }

    private inner class ViewHolder(private val binding: OffersSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val nestedAdapter = OffersAdapter(onClick)

        fun bind(item: MainScreenViews.OffersSection) {
            binding.run {
                offersRecycleView.layoutManager =
                    LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                offersRecycleView.adapter = nestedAdapter
                nestedAdapter.submitList(item.offerList)
            }
        }
    }
}