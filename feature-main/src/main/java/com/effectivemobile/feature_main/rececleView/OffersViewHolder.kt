package com.effectivemobile.feature_main.rececleView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.effectivemobile.domain.models.OfferModel
import com.effectivemobile.feature_main.databinding.OffersItemBinding

class OffersViewHolder(private val binding: OffersItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: OfferModel, onClick: (link: String) -> Unit) {

        binding.run {
            when (item.id) {
                "near_vacancies" -> {
                    offersImage.setImageResource(com.effectivemobile.core.R.drawable.ic_location)
                    offersImage.setBackgroundResource(com.effectivemobile.core.R.drawable.icon_rounded_background_blue)
                }

                "level_up_resume" -> {
                    offersImage.setImageResource(com.effectivemobile.core.R.drawable.ic_star)
                    offersImage.setBackgroundResource(com.effectivemobile.core.R.drawable.icon_rounded_background_green)
                }

                "temporary_job" -> {
                    offersImage.setImageResource(com.effectivemobile.core.R.drawable.ic_list)
                    offersImage.setBackgroundResource(com.effectivemobile.core.R.drawable.icon_rounded_background_green)
                }

                null -> offersImage.visibility = View.GONE
            }


            if (item.button != null) {
                offersButton.text = item.button!!.text
                offersButton.visibility = View.VISIBLE
                offersText.setLines(2)
            } else {
                offersButton.visibility = View.GONE
                offersText.setLines(3)
            }
            offersText.text = item.title


            cardView.setOnClickListener {
                onClick.invoke(item.link)
            }
        }
    }
}