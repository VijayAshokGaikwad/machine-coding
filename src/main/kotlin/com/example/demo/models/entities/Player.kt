package com.example.demo.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Player(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val playerId: Long,

    val name: String,

    val position: Int
)