package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.MatchPhoto
import com.example.android.marsphotos.network.MatchesApi

import kotlinx.coroutines.launch

class Matches_OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<List<MatchPhoto>>()
    // The external immutable LiveData for the request status
    val photos: LiveData<List<MatchPhoto>> = _photos
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMatchesPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMatchesPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = MatchesApi.retrofitService.getPhotos().data
                _status.value = "Success: Mars properties retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}