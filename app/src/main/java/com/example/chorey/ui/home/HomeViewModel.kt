package com.example.chorey.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chorey.data.Taak

class HomeViewModel : ViewModel() {


    private val _navigateToArtworkDetail = MutableLiveData<Int?>()
    val navigateToArtworkDetail
        get() = _navigateToArtworkDetail

    fun onTaakClicked(taakId: Int){

        _navigateToArtworkDetail.value = taakId
    }

    fun onTaakNavigated(){
        _navigateToArtworkDetail.value = null
    }
}