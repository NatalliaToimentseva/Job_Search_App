package com.effectivemobile.core.commonAdapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.core.commonViewHolder.VacancyViewHolder
import com.effectivemobile.core.databinding.VacancyItemBinding
import com.effectivemobile.core.models.GeneralScreenViews
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class VacancyAdapterDelegate(
    private val onFavoriteClick: (id: String, isFavorite: Boolean) -> Unit,
    private val onClick: (id: String) -> Unit
) : AdapterDelegate<List<GeneralScreenViews>>() {

    override fun isForViewType(items: List<GeneralScreenViews>, position: Int): Boolean {
        return items[position] is GeneralScreenViews.VacancySection
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return VacancyViewHolder(
            VacancyItemBinding.inflate(
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
        val vacancySection = items[position] as GeneralScreenViews.VacancySection
        (holder as VacancyViewHolder).bind(vacancySection.vacancy, onFavoriteClick, onClick)
    }
}