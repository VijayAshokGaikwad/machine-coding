package com.example.demo.models.request

import jakarta.persistence.*

data class TrelloList(
    val trelloListId: Long = 0,
    val name: String,
    var trelloCard: MutableSet<TrelloCard> = mutableSetOf()
)
