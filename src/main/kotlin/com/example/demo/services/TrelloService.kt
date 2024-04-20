package com.example.demo.services

import com.example.demo.models.request.*
import com.example.demo.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TrelloService(
//    @Autowired private val trelloBoardRepository: TrelloBoardRepository,
//    @Autowired private val trelloCardRepository: TrelloCardRepository,
//    @Autowired private val trelloListRepository: TrelloListRepository,
//    @Autowired private val trelloUserRepository: TrelloUserRepository,
//    @Autowired private val boardMemberRepository: BoardMemberRepository,
) {

//    fun save(
//        trelloUsers: List<TrelloUser>,
//        boards: List<TrelloBoard>,
//        trelloList: List<TrelloList>,
//        cards: Set<TrelloCard>
//    ) {
//        trelloUserRepository.saveAll(trelloUsers)
//        trelloBoardRepository.saveAll(boards)
//        trelloListRepository.saveAll(trelloList)
//        trelloCardRepository.saveAll(cards)
//    }

    fun getBoards(): List<TrelloBoard> {
        return listOf()
    }

}
