package com.effectivemobile.feature_main.generalAdapter

import androidx.recyclerview.widget.DiffUtil
import com.effectivemobile.feature_main.adapterDelegate.AllVacanciesTopSectionAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.ButtonAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.OffersAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.SearchSectionAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.TitleAdapterDelegate
import com.effectivemobile.feature_main.adapterDelegate.VacancyAdapterDelegate
import com.effectivemobile.feature_main.models.MainScreenViews
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainAdapter(
    onClickOffers: (link: String) -> Unit,
    onFavoriteClickVacancy: (isFavorite: Boolean) -> Unit,
    onClickVacancy: (id: String) -> Unit,
    showAllVacancies: (isShow: Boolean) -> Unit

) : AsyncListDifferDelegationAdapter<MainScreenViews>(object :
    DiffUtil.ItemCallback<MainScreenViews>() {

    override fun areItemsTheSame(oldItem: MainScreenViews, newItem: MainScreenViews): Boolean {
        return oldItem.isSameItem(newItem)
    }

    override fun areContentsTheSame(oldItem: MainScreenViews, newItem: MainScreenViews): Boolean {
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
