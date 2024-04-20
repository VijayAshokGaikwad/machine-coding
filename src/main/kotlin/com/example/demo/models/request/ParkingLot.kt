package com.example.demo.models.request

data class ParkingLot (
    val id: String,
    var floors: MutableList<Floor>
)
