package com.effectivemobile.feature_main.recycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.effectivemobile.domain.models.OfferModel
import com.effectivemobile.feature_main.databinding.OffersItemBinding

class OffersAdapter (private val onClick: (link: String) -> Unit):
    ListAdapter<OfferModel, OffersViewHolder>(OffersDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        return OffersViewHolder(
            OffersItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}