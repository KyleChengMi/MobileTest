package com.example.mobiletest

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobiletest.ui.theme.MobileTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    SegmentListUI(context)
                }
            }
        }
    }

    @Composable
    fun SegmentListUI(context: Context) {
        val repository = DataRepository(context)
        val viewModel = BookingViewModel(repository)
        viewModel.getData()

        viewModel.bookingItem?.segmentList?.let { segments ->
            LazyColumn {
                items(segments) { segment ->
                    Column {
                        Text("ID: ${segment.id}")
                        Text("Origin: ${segment.originAndDestinationPair.origin.displayName}")
                        Text("Destination: ${segment.originAndDestinationPair.destination.displayName}")
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MobileTestTheme {
            val context = LocalContext.current
            SegmentListUI(context)
        }
    }
}