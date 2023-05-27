package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.Employee
import com.example.android.marsphotos.network.EmployeesApi

import kotlinx.coroutines.launch
import kotlin.math.floor
import kotlin.random.Random

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
//    private val _photos = MutableLiveData<Employee>()
    private val _photos = MutableLiveData<List<Employee>>()
//    val photos: LiveData<Employee> = _photos
    val photos: LiveData<List<Employee>> = _photos
    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getFootballclubEmployees()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getFootballclubEmployees() {
        viewModelScope.launch {
            try {
//                var random = Random.nextInt(MarsApi.retrofitService.getEmployees().data.size)
//                _photos.value = MarsApi.retrofitService.getEmployees().data[0]
                _photos.value = EmployeesApi.retrofitService.getEmployees().data
                _status.value = "Success: Mars properties retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}