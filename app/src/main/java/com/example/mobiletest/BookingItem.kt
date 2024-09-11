package com.example.mobiletest

data class BookingItem(
    val shipReference: String,
    val shipToken: String,
    val canIssueTicketChecking: Boolean,
    val expiryTime: String,
    val duration: Int,
    val segments: List<Segment>
)

data class Segment(
    val id: Int,
    val originAndDestinationPair: OriginAndDestinationPair
)

data class OriginAndDestinationPair(
    val destination: Destination,
    val destinationCity: String,
    val origin: Origin,
    val originCity: String
)

data class Destination(
    val code: String,
    val displayName: String,
    val url: String
)

data class Origin(
    val code: String,
    val displayName: String,
    val url: String
)