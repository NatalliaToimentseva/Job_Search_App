package com.effectivemobile.feature_favorite.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.core.models.GeneralScreenViews
import com.effectivemobile.core.utils.matchVacancies
import com.effectivemobile.feature_favorite.databinding.FavoriteTopBarItemBinding
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class FavoriteTopSectionAdapterDelegate : AdapterDelegate<List<GeneralScreenViews>>() {

    override fun isForViewType(items: List<GeneralScreenViews>, position: Int): Boolean {
        return items[position] is GeneralScreenViews.FavoriteTopSection
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(
            FavoriteTopBarItemBinding.inflate(
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
        (holder as ViewHolder).bind(items[position] as GeneralScreenViews.FavoriteTopSection)
    }

    private inner class ViewHolder(private val binding: FavoriteTopBarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GeneralScreenViews.FavoriteTopSection) {
            binding.vacanciesNumberIcon.text = matchVacancies(item.vacancyNumber)
        }
    }
}