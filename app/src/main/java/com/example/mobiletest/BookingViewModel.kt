package com.example.mobiletest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class BookingViewModel(private val repository: DataRepository) {

    private val _bookingItemLiveData = MutableLiveData<BookingItem>()
    val bookingItemLiveData: LiveData<BookingItem> = _bookingItemLiveData

    fun getData() {
        _bookingItemLiveData.value = repository.getData()
    }
}