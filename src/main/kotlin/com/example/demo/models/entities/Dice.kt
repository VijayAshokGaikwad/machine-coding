package com.example.demo.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Dice(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val diceId: Long,

    val diceValue: Int
)