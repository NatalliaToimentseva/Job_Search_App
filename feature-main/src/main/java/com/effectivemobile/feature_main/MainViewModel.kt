package com.effectivemobile.feature_main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.effectivemobile.domain.controller.DataController
import com.effectivemobile.domain.models.JobModel
import com.effectivemobile.domain.results.JobResult
import com.effectivemobile.domain.useCases.LoadJobDataUseCase
import com.effectivemobile.feature_main.models.MainScreenViews
import com.effectivemobile.feature_main.utils.convertToMainScreenViews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val loadJobDataUseCase: LoadJobDataUseCase,
    private val dataController: DataController
) : ViewModel() {

    val isInProgress = MutableLiveData(false)
    var error: ((message: String) -> Unit)? = null

    private val _mainScreenElements = MutableLiveData<List<MainScreenViews>>()
    val mainScreenElements: LiveData<List<MainScreenViews>> get() = _mainScreenElements

    private val isShowAllVacancies = MutableLiveData(false)

    private val _jobState = MutableLiveData<JobModel>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadJobDataUseCase.loadJob().collect { result ->
                when (result) {
                    is JobResult.Error -> {
                        isInProgress.postValue(false)
                        error?.invoke(result.message)
                    }

                    JobResult.Loading -> isInProgress.postValue(true)
                    JobResult.Success -> {
                        isInProgress.postValue(false)
                        Log.i("JobDataLoading", "Job data was loaded")
                    }
                }
            }
        }
        viewModelScope.launch {
            dataController.listenJobData().collect { jobData ->
                _jobState.postValue(jobData)
                createMainScreenViews(jobData)
            }
        }
    }

    fun setIsShowAllVacancies(isShow: Boolean) {
        isShowAllVacancies.postValue(isShow)
        _jobState.value?.let { createMainScreenViews(it) }
    }

    private fun createMainScreenViews(jobData: JobModel) {
        isShowAllVacancies.value?.let {
            _mainScreenElements.postValue(convertToMainScreenViews(it, jobData))
        }
    }
}

