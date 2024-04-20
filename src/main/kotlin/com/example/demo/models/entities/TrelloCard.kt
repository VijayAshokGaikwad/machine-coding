//package com.example.demo.models.entities
//
//import jakarta.persistence.*
//
//@Entity
//data class TrelloCard(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "trello_card_id")
//    val trelloCardId: Long = 0,
//
//    @Column(nullable = false)
//    val name: String,
//
//    @Column(nullable = true)
//    val description: String? = null,
//
//    @ManyToOne
//    @JoinColumn(name = "trello_board_id", referencedColumnName = "trello_board_id")
//    val trelloBoard: TrelloBoard,
//
//    @ManyToOne
//    @JoinColumn(name = "trello_list_id", referencedColumnName = "trello_list_id")
//    val trelloList: TrelloList,
//
//    @ManyToOne
//    @JoinColumn(name = "assigned_user_id", referencedColumnName = "trello_user_id")
//    val assignedUser: TrelloUser?
//)
