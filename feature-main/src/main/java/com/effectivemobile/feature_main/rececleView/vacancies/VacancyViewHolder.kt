package com.effectivemobile.feature_main.rececleView.vacancies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.domain.models.VacancyModel
import com.effectivemobile.feature_main.databinding.VacancyItemBinding

class VacancyViewHolder(private val binding: VacancyItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: VacancyModel,
        onFavoriteClick: (isFavorite: Boolean) -> Unit,
        onClick: (id: String) -> Unit
    ) {

        binding.run {
            if (item.lookingNumber != null) {
                lookingNumber.visibility = View.VISIBLE
                lookingNumber.text = item.lookingNumber.toString()
            } else lookingNumber.visibility = View.GONE
            if (item.isFavorite) {
                isFavoriteImage.setImageResource(com.effectivemobile.core.R.drawable.ic_active_like)
            } else isFavoriteImage.setImageResource(com.effectivemobile.core.R.drawable.ic_favorite)
            vacancyTitle.text = item.title
            vacancyCity.text = item.address.town
            vacancyCompany.text = item.company
            vacancyExperience.text = item.experience.previewText
            vacancyPublishedDate.text = item.publishedDate

            isFavoriteImage.setOnClickListener {
                onFavoriteClick.invoke(item.isFavorite)
            }

            vacancyCardView.setOnClickListener {
                onClick.invoke(item.id)
            }
        }
    }
}