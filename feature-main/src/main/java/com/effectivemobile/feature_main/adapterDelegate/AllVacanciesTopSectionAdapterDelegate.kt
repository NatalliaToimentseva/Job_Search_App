package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.databinding.AllVacanciesTopSectionBinding
import com.effectivemobile.core.models.GeneralScreenViews
import com.effectivemobile.core.utils.matchVacancies
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class AllVacanciesTopSectionAdapterDelegate(
    private val showAllVacancies: (isShow: Boolean) -> Unit
) : AdapterDelegate<List<GeneralScreenViews>>() {

    override fun isForViewType(items: List<GeneralScreenViews>, position: Int): Boolean {
        return items[position] is GeneralScreenViews.AllVacanciesTopSection
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(
            AllVacanciesTopSectionBinding.inflate(
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
        (holder as ViewHolder).bind(
            items[position] as GeneralScreenViews.AllVacanciesTopSection,
            showAllVacancies
        )
    }

    private inner class ViewHolder(private val binding: AllVacanciesTopSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: GeneralScreenViews.AllVacanciesTopSection,
            showAllVacancies: (isShow: Boolean) -> Unit
        ) {
            binding.vacanciesNumberIcon.text = matchVacancies(item.vacancyNumber)
            binding.searchBar.setOnSearchClickListener {
                showAllVacancies.invoke(false)
            }
        }
    }
}