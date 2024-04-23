package com.example.demo.models.tictactoe

data class Player(
    val id: Long = 0,
    val name: String,
    val piece: Piece,
    val allPositions: MutableList<Pair<Int, Int>> = mutableListOf()
)
