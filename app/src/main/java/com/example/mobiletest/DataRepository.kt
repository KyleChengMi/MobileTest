package com.example.mobiletest

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.concurrent.TimeUnit

class DataRepository(private val context: Context) {

    private var bookingItem: BookingItem? = null
    private var lastUpdatedTime: Long = 0

    fun getData(): BookingItem? {
        if (isCacheExpired()) {
            refreshData()
        }
        return bookingItem
    }

    private fun isCacheExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        return currentTime - lastUpdatedTime > TimeUnit.MINUTES.toMillis(5)
    }

    private fun refreshData() {
        try {
            val inputStream = context.resources.openRawResource(R.raw.booking)
            val reader = inputStream.bufferedReader()
            val gson = Gson()
            val jsonString = reader.readText()
            bookingItem = gson.fromJson(jsonString, BookingItem::class.java)
            lastUpdatedTime = System.currentTimeMillis()
            reader.close()
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
            println("Error occurred while refreshing data.")
        }
    }

    fun saveData(newData: BookingItem) {
        try {
            val gson = GsonBuilder().setPrettyPrinting().create()
            val jsonData = gson.toJson(newData)
            println("Saving data: $jsonData")
            bookingItem = newData
            lastUpdatedTime = System.currentTimeMillis()
        } catch (e: Exception) {
            e.printStackTrace()
            println("Error occurred while saving data.")
        }
    }
}