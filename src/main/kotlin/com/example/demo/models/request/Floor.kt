package com.example.demo.models.request

data class Floor(
    val id: Long = 0,
    val slots: MutableList<ParkingSlot>
)