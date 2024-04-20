//package com.example.demo.models.entities
//
//import jakarta.persistence.*
//
//@Entity
//@Table(name = "trello_board")
//data class TrelloBoard(
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "trello_board_id")
//    val boardId: Long,
//
//    val name: String,
//
//    @OneToMany(mappedBy = "trello_board", cascade = [CascadeType.ALL], orphanRemoval = true)
//    var members: MutableSet<BoardMember> = mutableSetOf(),
//
//    @OneToMany(mappedBy = "trello_board", cascade = [CascadeType.ALL], orphanRemoval = true)
//    var trelloList: MutableList<TrelloList> = mutableListOf(),
//)
