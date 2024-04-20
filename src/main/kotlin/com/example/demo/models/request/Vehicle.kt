package com.example.demo.models.request

data class Vehicle(
    val id: Long = 0,
    val color: String,
    val vehicleType: VehicleType
)