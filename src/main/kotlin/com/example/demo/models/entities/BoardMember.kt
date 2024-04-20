//package com.example.demo.models.entities
//
//import jakarta.persistence.Entity
//import jakarta.persistence.GeneratedValue
//import jakarta.persistence.GenerationType
//import jakarta.persistence.Id
//import jakarta.persistence.JoinColumn
//import jakarta.persistence.ManyToOne
//
//@Entity
//data class BoardMember(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long = 0,
//
//    @ManyToOne
//    @JoinColumn(name = "trello_board_id", referencedColumnName = "trello_board_id")
//    val trelloBoard: TrelloBoard,
//
//    @ManyToOne
//    @JoinColumn(name = "trello_user_id", referencedColumnName = "trello_user_id")
//    val trelloUser: TrelloUser,
//)
