package com.effectivemobile.feature_main.rececleView.vacancies

import androidx.recyclerview.widget.DiffUtil
import com.effectivemobile.domain.models.VacancyModel

class VacancyDiffUtils : DiffUtil.ItemCallback<VacancyModel>() {

    override fun areItemsTheSame(
        oldItem: VacancyModel,
        newItem: VacancyModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: VacancyModel,
        newItem: VacancyModel
    ): Boolean {
        return oldItem == newItem
    }
}