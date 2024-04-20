package com.example.demo.models.request

import jakarta.persistence.*

data class TrelloCard(
    val trelloCardId: Long = 0,
    val name: String,
    val description: String? = null,
    val assignedUser: TrelloUser?
)
