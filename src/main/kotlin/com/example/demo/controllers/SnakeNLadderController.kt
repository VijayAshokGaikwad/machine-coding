package com.example.demo.controllers

import com.example.demo.models.entities.Ladder
import com.example.demo.models.entities.Movement
import com.example.demo.models.entities.Player
import com.example.demo.models.entities.Snake
import com.example.demo.services.SnakeNLadderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class SnakeNLadderController(@Autowired val snakeNLadderService: SnakeNLadderService) {

    @GetMapping("/result")
    fun getResult(): ResponseEntity<List<Movement>> {
        val numOfSnakes = 9
        val snakes = listOf<Snake>(
            Snake(Math.random().toLong(),62 ,5 ),
            Snake(Math.random().toLong(),33 ,6 ),
            Snake(Math.random().toLong(),49 ,9 ),
            Snake(Math.random().toLong(),88 ,16 ),
            Snake(Math.random().toLong(),41 ,20 ),
            Snake(Math.random().toLong(),56 ,53 ),
            Snake(Math.random().toLong(),98 ,64 ),
            Snake(Math.random().toLong(),93 ,73 ),
            Snake(Math.random().toLong(),95 ,75 ),
        )

        val numOfLadders = 8
        val ladders = listOf<Ladder>(
            Ladder(Math.random().toLong(),2, 37),
            Ladder(Math.random().toLong(),27, 46),
            Ladder(Math.random().toLong(),10, 32),
            Ladder(Math.random().toLong(),51, 68 ),
            Ladder(Math.random().toLong(),61, 79 ),
            Ladder(Math.random().toLong(),65, 84 ),
            Ladder(Math.random().toLong(),71, 91 ),
            Ladder(Math.random().toLong(),81, 100 )
        )

        val numUsers = 2
        val users = listOf(
            Player(Math.random().toLong(), "G", 0),
            Player(Math.random().toLong(), "S", 0)
        )

        val listOfDiceInputs = listOf(6, 1, 6, 4, 4, 6, 5, 4, 1, 6, 6, 2, 6, 6, 5, 2, 2, 5, 3, 5, 6, 3, 2, 3, 3, 5, 3, 4, 2, 5, 2, 5, 2, 6, 3, 3, 5, 2, 5, 6, 5, 1, 4, 2, 5, 4, 1, 6, 3, 4, 1, 1, 1, 5, 6, 3,)

        val turn = 0

        snakeNLadderService.saveAll(users, ladders, snakes)

        val result: List<Movement> = snakeNLadderService.getResult(users, ladders, snakes, listOfDiceInputs, turn)

        return ResponseEntity.ok(result)
    }

}