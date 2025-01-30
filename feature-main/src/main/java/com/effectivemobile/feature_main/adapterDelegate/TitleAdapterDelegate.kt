package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.databinding.TitleSectionBinding
import com.effectivemobile.feature_main.models.MainScreenViews
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class TitleAdapterDelegate : AdapterDelegate<List<MainScreenViews>>() {

    override fun isForViewType(items: List<MainScreenViews>, position: Int): Boolean {
        return items[position] is MainScreenViews.TitleSection
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(
            TitleSectionBinding.inflate(
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

    private inner class ViewHolder(binding: TitleSectionBinding) :
        RecyclerView.ViewHolder(binding.root)
}