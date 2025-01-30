package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.R
import com.effectivemobile.feature_main.databinding.ButtonSectionBinding
import com.effectivemobile.feature_main.models.MainScreenViews
import com.effectivemobile.feature_main.utils.matchVacancies
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class ButtonAdapterDelegate : AdapterDelegate<List<MainScreenViews>>() {

    override fun isForViewType(items: List<MainScreenViews>, position: Int): Boolean {
        return items[position] is MainScreenViews.ButtonSection
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(
            ButtonSectionBinding.inflate(
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
        (holder as ViewHolder).bind(items[position] as MainScreenViews.ButtonSection)
    }

    private inner class ViewHolder(private val binding: ButtonSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MainScreenViews.ButtonSection) {
            binding.mainButton.text =
                binding.root.context.getString(
                    R.string.button_vacancies_title,
                    matchVacancies(item.vacancyNumber)
                )
        }
    }
}