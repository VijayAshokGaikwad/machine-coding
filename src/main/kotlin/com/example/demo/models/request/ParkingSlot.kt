package com.example.demo.models.request

data class ParkingSlot(
    val id: Long,
    val suitableFor: VehicleType,
    var available: Boolean
)