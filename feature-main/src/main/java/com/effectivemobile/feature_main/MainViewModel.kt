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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val loadJobDataUseCase: LoadJobDataUseCase,
    private val dataController: DataController
): ViewModel() {

    val isInProgress = MutableLiveData(false)
    var error: ((message: String) -> Unit)? = null

    private val _jobState = MutableLiveData<JobModel>()
    val jobState: LiveData<JobModel> get() = _jobState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadJobDataUseCase.loadJob().collect { result ->
                when(result) {
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
            dataController.listenJobData().collect{ jobData ->
                _jobState.postValue(jobData)
            }
        }
    }
}

