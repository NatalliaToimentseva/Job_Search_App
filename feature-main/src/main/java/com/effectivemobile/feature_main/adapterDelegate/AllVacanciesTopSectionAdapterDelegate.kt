package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.databinding.AllVacanciesTopSectionBinding
import com.effectivemobile.feature_main.models.MainScreenViews
import com.effectivemobile.feature_main.utils.matchVacancies
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class AllVacanciesTopSectionAdapterDelegate(
    private val showAllVacancies: (isShow: Boolean) -> Unit
) : AdapterDelegate<List<MainScreenViews>>() {

    override fun isForViewType(items: List<MainScreenViews>, position: Int): Boolean {
        return items[position] is MainScreenViews.AllVacanciesTopSection
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
        items: List<MainScreenViews>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as ViewHolder).bind(
            items[position] as MainScreenViews.AllVacanciesTopSection,
            showAllVacancies
        )
    }

    private inner class ViewHolder(private val binding: AllVacanciesTopSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: MainScreenViews.AllVacanciesTopSection,
            showAllVacancies: (isShow: Boolean) -> Unit
        ) {
            binding.vacanciesNumberIcon.text = matchVacancies(item.vacancyNumber)
            binding.searchBar.setOnSearchClickListener {
                showAllVacancies.invoke(false)
            }
        }
    }
}