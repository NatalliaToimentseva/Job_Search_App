package com.effectivemobile.feature_favorite.mainAdapter

import androidx.recyclerview.widget.DiffUtil
import com.effectivemobile.core.commonAdapterDelegate.VacancyAdapterDelegate
import com.effectivemobile.core.models.GeneralScreenViews
import com.effectivemobile.feature_favorite.adapterDelegate.FavoriteTopSectionAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class FavoriteMainAdapter(
    onFavoriteClick: (id: String, isFavorite: Boolean) -> Unit,
    onClick: (id: String) -> Unit
) : AsyncListDifferDelegationAdapter<GeneralScreenViews>(object :
    DiffUtil.ItemCallback<GeneralScreenViews>() {

    override fun areItemsTheSame(
        oldItem: GeneralScreenViews,
        newItem: GeneralScreenViews
    ): Boolean {
        return oldItem.isSameItem(newItem)
    }

    override fun areContentsTheSame(
        oldItem: GeneralScreenViews,
        newItem: GeneralScreenViews
    ): Boolean {
        return oldItem.isSameContent(newItem)
    }
}) {

    init {
        delegatesManager.addDelegate(FavoriteTopSectionAdapterDelegate())
        delegatesManager.addDelegate(
            VacancyAdapterDelegate(
                onFavoriteClick = onFavoriteClick,
                onClick = onClick
            )
        )
    }
}