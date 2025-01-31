package com.effectivemobile.core.commonViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.core.R
import com.effectivemobile.core.databinding.VacancyItemBinding
import com.effectivemobile.core.utils.matchLookingNumber
import com.effectivemobile.core.utils.matchMonths
import com.effectivemobile.domain.models.VacancyModel

class VacancyViewHolder(private val binding: VacancyItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: VacancyModel,
        onFavoriteClick: (id: String, isFavorite: Boolean) -> Unit,
        onClick: (id: String) -> Unit
    ) {

        binding.run {
            if (item.lookingNumber != null) {
                lookingNumber.visibility = View.VISIBLE
                lookingNumber.text = binding.root.context.getString(
                    R.string.looking_number_text,
                    matchLookingNumber(item.lookingNumber!!)
                )
            } else lookingNumber.visibility = View.GONE
            if (item.isFavorite) {
                isFavoriteImage.setImageResource(R.drawable.ic_active_like)
            } else isFavoriteImage.setImageResource(R.drawable.ic_favorite)
            vacancyTitle.text = item.title
            vacancyCity.text = item.address.town
            vacancyCompany.text = item.company
            vacancyExperience.text = item.experience.previewText
            vacancyPublishedDate.text =
                binding.root.context.getString(
                    R.string.vacancy_published_date,
                    matchMonths(item.publishedDate)
                )

            isFavoriteImage.setOnClickListener {
                onFavoriteClick.invoke(item.id, item.isFavorite)
            }

            vacancyCardView.setOnClickListener {
                onClick.invoke(item.id)
            }
        }
    }
}