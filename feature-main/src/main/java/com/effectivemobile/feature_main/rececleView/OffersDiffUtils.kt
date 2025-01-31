package com.effectivemobile.feature_main.rececleView

import androidx.recyclerview.widget.DiffUtil
import com.effectivemobile.domain.models.OfferModel

class OffersDiffUtils : DiffUtil.ItemCallback<OfferModel>() {

    override fun areItemsTheSame(
        oldItem: OfferModel,
        newItem: OfferModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: OfferModel,
        newItem: OfferModel
    ): Boolean {
        return oldItem == newItem
    }
}