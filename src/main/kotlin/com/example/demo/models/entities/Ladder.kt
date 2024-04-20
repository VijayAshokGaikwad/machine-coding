package com.example.demo.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Ladder(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val ladderId: Long,

    val fromPosition: Int,

    val toPosition: Int
)