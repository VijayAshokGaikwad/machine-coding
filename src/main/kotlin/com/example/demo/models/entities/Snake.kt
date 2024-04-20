package com.example.demo.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Snake(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val snakeId: Long,

    val fromPosition: Int,

    val toPosition: Int
)