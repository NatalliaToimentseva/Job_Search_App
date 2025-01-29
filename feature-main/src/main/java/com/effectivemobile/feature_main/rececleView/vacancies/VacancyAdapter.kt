package com.effectivemobile.feature_main.rececleView.vacancies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.effectivemobile.domain.models.VacancyModel
import com.effectivemobile.feature_main.databinding.VacancyItemBinding

class VacancyAdapter(
    private val onFavoriteClick: (isFavorite: Boolean) -> Unit,
    private val onClick: (id: String) -> Unit
) : ListAdapter<VacancyModel, VacancyViewHolder>(VacancyDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        return VacancyViewHolder(
            VacancyItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        holder.bind(getItem(position), onFavoriteClick, onClick)
    }
}