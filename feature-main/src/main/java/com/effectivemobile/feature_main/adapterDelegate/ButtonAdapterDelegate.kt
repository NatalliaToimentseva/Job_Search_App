package com.effectivemobile.feature_main.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.feature_main.R
import com.effectivemobile.feature_main.databinding.ButtonSectionBinding
import com.effectivemobile.core.models.GeneralScreenViews
import com.effectivemobile.core.utils.matchVacancies
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class ButtonAdapterDelegate(
    private val showAllVacancies: (isShow: Boolean) -> Unit
) : AdapterDelegate<List<GeneralScreenViews>>() {

    override fun isForViewType(items: List<GeneralScreenViews>, position: Int): Boolean {
        return items[position] is GeneralScreenViews.ButtonSection
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
        items: List<GeneralScreenViews>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as ViewHolder).bind(
            items[position] as GeneralScreenViews.ButtonSection,
            showAllVacancies
        )
    }

    private inner class ViewHolder(private val binding: ButtonSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: GeneralScreenViews.ButtonSection,
            showAllVacancies: (isShow: Boolean) -> Unit
        ) {
            binding.mainButton.text =
                binding.root.context.getString(
                    R.string.button_vacancies_title,
                    matchVacancies(item.vacancyNumber)
                )
            binding.mainButton.setOnClickListener {
                showAllVacancies.invoke(true)
            }
        }
    }
}