package com.example.demo.models.request

import jakarta.persistence.*

data class TrelloBoard(

    val boardId: Long,

    val name: String,

    var members: MutableSet<TrelloUser> = mutableSetOf(),

    var trelloList: MutableSet<TrelloList> = mutableSetOf()
)
