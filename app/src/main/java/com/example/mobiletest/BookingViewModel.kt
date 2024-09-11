package com.example.mobiletest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class BookingViewModel(private val repository: DataRepository) {

    private var _bookingItem by mutableStateOf<BookingItem?>(null)

    val bookingItem: BookingItem?
        get() = _bookingItem

    fun getData() {
        _bookingItem = repository.getData()
    }
}