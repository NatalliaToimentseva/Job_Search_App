package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.databinding.VacancyItemBinding
import com.effectivemobile.feature_main.models.MainScreenViews
import com.effectivemobile.feature_main.rececleView.vacancies.VacancyViewHolder
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class VacancyAdapterDelegate(
    private val onFavoriteClick: (isFavorite: Boolean) -> Unit,
    private val onClick: (id: String) -> Unit
) : AdapterDelegate<List<MainScreenViews>>() {

    override fun isForViewType(items: List<MainScreenViews>, position: Int): Boolean {
        return items[position] is MainScreenViews.VacancySection
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
        items: List<MainScreenViews>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val vacancySection = items[position] as MainScreenViews.VacancySection
        (holder as VacancyViewHolder).bind(vacancySection.vacancy, onFavoriteClick, onClick)
    }
}