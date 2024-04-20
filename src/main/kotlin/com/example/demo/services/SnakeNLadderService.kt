package com.example.demo.services

import com.example.demo.models.entities.Ladder
import com.example.demo.models.entities.Movement
import com.example.demo.models.entities.Player
import com.example.demo.models.entities.Snake
import com.example.demo.repositories.LadderRepository
import com.example.demo.repositories.PlayerRepository
import com.example.demo.repositories.SnakeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SnakeNLadderService(
    @Autowired private val snakeRepository: SnakeRepository,
    @Autowired private val ladderRepository: LadderRepository,
    @Autowired private val playerRepository: PlayerRepository,
) {

    fun saveAll(users: List<Player>, ladders: List<Ladder>, snakes: List<Snake>) {
        playerRepository.saveAll(users)
        ladderRepository.saveAll(ladders)
        snakeRepository.saveAll(snakes)
    }

    fun getResult(
        users: List<Player>,
        ladders: List<Ladder>,
        snakes: List<Snake>,
        listOfDiceInputs: List<Int>,
        turn: Int
    ): List<Movement> {
        val userIds: List<Long> = playerRepository.findAll().map { it.playerId }
        var index = 0
        var userIdWhoseTurnIs = userIds[0]

        val movements = mutableListOf<Movement>()

        for (input in listOfDiceInputs) {
            val playerWhoseTurnIs =
                playerRepository.findById(userIdWhoseTurnIs).orElseThrow { Exception("Player not found") }

            val fromPosition = playerWhoseTurnIs.position

            val updatedPosition = updatePosition(playerWhoseTurnIs, currentInput = input)

            // Board entity can be created - Board has - snakes, ladders, players, size default 100
            // 100 can be replaced by Board size
            if (updatedPosition == 100) {
                updatePlayer(playerWhoseTurnIs, updatedPosition)

                movements.add(Movement(playerWhoseTurnIs.name, input, fromPosition, updatedPosition))

                println("${playerWhoseTurnIs.name} is winner")
                break
            } else if (updatedPosition > 100) {

                movements.add(Movement(playerWhoseTurnIs.name, input, fromPosition, playerWhoseTurnIs.position))
                index = changeTurn(userIds, index)
                userIdWhoseTurnIs = userIds[index]

                continue
            }

            updatePlayer(playerWhoseTurnIs, updatedPosition)

            movements.add(Movement(playerWhoseTurnIs.name, input, fromPosition, updatedPosition))
            index = changeTurn(userIds, index)
            userIdWhoseTurnIs = userIds[index]
        }

        return movements
    }

    private fun updatePlayer(playerWhoseTurnIs: Player, updatedPosition: Int) {
        val updatedPlayer: Player = playerWhoseTurnIs.copy(position = updatedPosition)
        playerRepository.save(updatedPlayer)
    }

    private fun changeTurn(userIds: List<Long>, index: Int): Int {
        return (index + 1) % userIds.size
    }

    private fun updatePosition(
        playerWhoseTurnIs: Player,
        currentInput: Int
    ): Int {
        var resultantPosition = playerWhoseTurnIs.position + currentInput

        val ladder = ladderRepository.findByFromPosition(resultantPosition)

        if (ladder.isPresent) {
            resultantPosition = ladder.get().toPosition
        }

        val snake = snakeRepository.findByFromPosition(resultantPosition)

        if (snake.isPresent) {
            resultantPosition = snake.get().toPosition
        }

        return resultantPosition
    }

}
