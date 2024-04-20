package com.example.demo.controllers

import com.example.demo.models.request.*
import com.example.demo.services.TrelloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class TrelloController(
    @Autowired private val trelloService : TrelloService
) {

    val trelloUsers1 = TrelloUser(1, "U1")
    val trelloUsers2 = TrelloUser(2, "U2")
    val users = mutableSetOf(trelloUsers1, trelloUsers2)

    val card = TrelloCard(1, "C1", "some", null)
    val cards = mutableSetOf(card)

    val card2 = TrelloCard(2, "C2", "some desc", null)
    val cards2 = mutableSetOf(card2)

    val trelloList = TrelloList(1, "L1", cards)
    val trelloLists = mutableSetOf(trelloList)

    val trelloList2 = TrelloList(2, "L2", cards2)
    val trelloLists2 = mutableSetOf(trelloList2)

    val board1 = TrelloBoard(1, "B1", users,  trelloLists)
    val board2 = TrelloBoard(2, "B2", users,  trelloLists2)
    val boards = listOf(board1, board2)

    @GetMapping("/board")
    fun getBoard(): ResponseEntity<List<TrelloBoard>> {

        return ResponseEntity.ok(boards)
    }

    @PostMapping("/board/{id}/lists")
    fun addList(@RequestBody trelloList: TrelloList, @PathVariable id: String): ResponseEntity<TrelloBoard> {
        val board = boards.first {
            it.boardId == id.toLong()
        }

        board.trelloList.add(trelloList)

        return ResponseEntity.ok(board)
    }

}