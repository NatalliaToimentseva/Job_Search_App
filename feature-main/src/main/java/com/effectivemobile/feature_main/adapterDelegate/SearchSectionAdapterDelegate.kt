package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.databinding.SearchSectionBinding
import com.effectivemobile.feature_main.models.MainScreenViews
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class SearchSectionAdapterDelegate : AdapterDelegate<List<MainScreenViews>>() {

    override fun isForViewType(items: List<MainScreenViews>, position: Int): Boolean {
        return items[position] is MainScreenViews.SearchSection
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(
            SearchSectionBinding.inflate(
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
    }

    private inner class ViewHolder(binding: SearchSectionBinding) :
        RecyclerView.ViewHolder(binding.root)
}