package com.example.mobiletest

data class BookingItem(
    val segmentList: List<Segment>
)

data class Segment(
    val id: Int,
    val originAndDestinationPair: OriginAndDestinationPair
)

data class OriginAndDestinationPair(
    val origin: Origin,
    val destination: Destination
)

data class Origin(
    val code: String,
    val displayName: String,
    val url: String
)

data class Destination(
    val code: String,
    val displayName: String,
    val url: String
)