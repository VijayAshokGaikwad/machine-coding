package com.example.demo.models.entities

data class Movement (
    val user: String,
    val dice: Int,
    val from: Int,
    val to: Int
)