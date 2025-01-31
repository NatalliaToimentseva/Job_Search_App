package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.databinding.OffersSectionBinding
import com.effectivemobile.core.commonModels.GeneralScreenViews
import com.effectivemobile.feature_main.recycleView.OffersAdapter
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class OffersAdapterDelegate(
    private val onClick: (link: String) -> Unit
) : AdapterDelegate<List<GeneralScreenViews>>() {

    override fun isForViewType(items: List<GeneralScreenViews>, position: Int): Boolean {
        return items[position] is GeneralScreenViews.OffersSection
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
        items: List<GeneralScreenViews>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as ViewHolder).bind(items[position] as GeneralScreenViews.OffersSection)
    }

    private inner class ViewHolder(private val binding: OffersSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val nestedAdapter = OffersAdapter(onClick)

        fun bind(item: GeneralScreenViews.OffersSection) {
            binding.run {
                offersRecycleView.layoutManager =
                    LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                offersRecycleView.adapter = nestedAdapter
                nestedAdapter.submitList(item.offerList)
            }
        }
    }
}