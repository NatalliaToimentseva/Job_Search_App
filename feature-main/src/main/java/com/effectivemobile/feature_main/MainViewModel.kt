package com.effectivemobile.feature_main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.effectivemobile.domain.models.OfferModel
import com.effectivemobile.domain.models.VacancyModel
import com.effectivemobile.domain.results.JobResult
import com.effectivemobile.domain.results.VacancyResult
import com.effectivemobile.domain.useCases.GetVacanciesFromDbUseCase
import com.effectivemobile.domain.useCases.LoadJobDataUseCase
import com.effectivemobile.domain.useCases.SetFavoriteUseCase
import com.effectivemobile.core.models.GeneralScreenViews
import com.effectivemobile.feature_main.utils.convertToMainScreenViews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val loadJobDataUseCase: LoadJobDataUseCase,
    private val getVacanciesFromDbUseCase: GetVacanciesFromDbUseCase,
    private val setFavoriteUseCase: SetFavoriteUseCase
) : ViewModel() {

    val isInProgress = MutableLiveData(false)
    var error: ((message: String) -> Unit)? = null

    private val _mainScreenElements = MutableLiveData<List<GeneralScreenViews>>(arrayListOf())
    val mainScreenElements: LiveData<List<GeneralScreenViews>> get() = _mainScreenElements

    private val isShowAllVacancies = MutableLiveData(false)

    private val _offers = MutableLiveData<List<OfferModel>>()
    private val _vacanciesList = MutableLiveData<List<VacancyModel>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadJobDataUseCase.loadJob().collect { result ->
                when (result) {
                    is JobResult.Loading -> isInProgress.postValue(true)
                    is JobResult.Error -> {
                        isInProgress.postValue(false)
                        error?.invoke(result.message)
                    }

                    is JobResult.Success -> {
                        isInProgress.postValue(false)
                        _offers.postValue(result.offersList)
                        Log.i("SuccessOperation", "Network: JobData was loaded")
                    }
                }
            }
        }
        viewModelScope.launch(Dispatchers.IO) {
            getVacanciesFromDbUseCase.getVacancies().collect { result ->
                handleResult(result)
            }
        }
    }

    fun setIsShowAllVacancies(isShow: Boolean) {
        isShowAllVacancies.postValue(isShow)
        _offers.value?.let { offers ->
            _vacanciesList.value?.let { vacancies ->
                createMainScreenViews(offers, vacancies)
            }
        }
    }

    private fun createMainScreenViews(offers: List<OfferModel>, vacancies: List<VacancyModel>) {
        isShowAllVacancies.value?.let {
            _mainScreenElements.postValue(convertToMainScreenViews(it, offers, vacancies))
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
                _vacanciesList.postValue(result.vacancyList)
                _offers.value?.let { offers ->
                    createMainScreenViews(offers, result.vacancyList)
                }
            }
        }
    }
}

