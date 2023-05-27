package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.Employee

import com.example.android.marsphotos.network.NewsApi

import com.example.android.marsphotos.network.NewsPhoto
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class News_OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<List<NewsPhoto>>()
    // The external immutable LiveData for the request status
    val photos: LiveData<List<NewsPhoto>> = _photos
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getNewsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getNewsPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = NewsApi.retrofitService.getPhotos().data
                _status.value = "Success: Mars properties retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}