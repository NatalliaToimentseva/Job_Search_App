package com.effectivemobile.feature_main.mainAdapter

import androidx.recyclerview.widget.DiffUtil
import com.effectivemobile.core.models.GeneralScreenViews
import com.effectivemobile.feature_main.adapterDelegate.AllVacanciesTopSectionAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.ButtonAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.OffersAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.SearchSectionAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.TitleAdapterDelegate
import com.effectivemobile.core.commonAdapterDelegate.VacancyAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainAdapter(
    onClickOffers: (link: String) -> Unit,
    onFavoriteClickVacancy: (id: String, isFavorite: Boolean) -> Unit,
    onClickVacancy: (id: String) -> Unit,
    showAllVacancies: (isShow: Boolean) -> Unit
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
        delegatesManager.addDelegate(AllVacanciesTopSectionAdapterDelegate(showAllVacancies = showAllVacancies))
        delegatesManager.addDelegate(SearchSectionAdapterDelegate())
        delegatesManager.addDelegate(OffersAdapterDelegate(onClick = onClickOffers))
        delegatesManager.addDelegate(TitleAdapterDelegate())
        delegatesManager.addDelegate(
            VacancyAdapterDelegate(
                onFavoriteClick = onFavoriteClickVacancy,
                onClick = onClickVacancy
            )
        )
        delegatesManager.addDelegate(ButtonAdapterDelegate(showAllVacancies = showAllVacancies))
    }
}
