package com.jkantech.kazi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    val editQtyLiveData:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()

    }
    val fLiveData:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()

    }
}