package com.effectivemobile.feature_favorite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.effectivemobile.core.models.GeneralScreenViews
import com.effectivemobile.domain.models.VacancyModel
import com.effectivemobile.domain.results.VacancyResult
import com.effectivemobile.domain.useCases.GetVacanciesFromDbUseCase
import com.effectivemobile.domain.useCases.SetFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getVacanciesFromDbUseCase: GetVacanciesFromDbUseCase,
    private val setFavoriteUseCase: SetFavoriteUseCase
) : ViewModel() {

    val isInProgress = MutableLiveData(false)
    var error: ((message: String) -> Unit)? = null

    private val _vacanciesList = MutableLiveData<List<VacancyModel>>()

    private val _screenViews = MutableLiveData<List<GeneralScreenViews>>(arrayListOf())
    val screenViews: LiveData<List<GeneralScreenViews>> get() = _screenViews

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getVacanciesFromDbUseCase.getVacancies().collect { result ->
                handleResult(result)
            }
        }
    }

    fun addToFavorite(id: String, isFavorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _vacanciesList.value?.firstOrNull { it.id == id }?.also { vacancy ->
                setFavoriteUseCase.setIsFavorite(vacancy.copy(isFavorite = !isFavorite))
                    .collect { result ->
                        handleResult(result)
                    }
            }
        }
    }

    private fun handleResult(result: VacancyResult) {
        when (result) {
            is VacancyResult.Loading -> isInProgress.postValue(true)
            is VacancyResult.Error -> {
                isInProgress.postValue(false)
                error?.invoke(result.message)
            }

            is VacancyResult.SuccessAdd -> {
                isInProgress.postValue(false)
                Log.i("SuccessOperation", "DB: vacancy was updated")
            }

            is VacancyResult.Success -> {
                isInProgress.postValue(false)
                val vacancies = result.vacancyList.filter { it.isFavorite }
                _vacanciesList.postValue(vacancies)

                _screenViews.postValue(
                    arrayListOf(GeneralScreenViews.FavoriteTopSection(vacancies.size))
                            + (vacancies.map { GeneralScreenViews.VacancySection(it) })
                )
            }
        }
    }
}