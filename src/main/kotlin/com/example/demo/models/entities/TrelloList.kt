//package com.example.demo.models.entities
//
//import jakarta.persistence.*
//
//@Entity
//@Table(name = "trello_list")
//data class TrelloList(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "trello_list_id")
//    val trelloListId: Long = 0,
//
//    @Column(nullable = false)
//    val name: String,
//
//    @ManyToOne
//    @JoinColumn(name = "trello_board_id", referencedColumnName = "trello_board_id")
//    val trelloBoard: TrelloBoard,
//
//    @OneToMany(mappedBy = "trello_list", cascade = [CascadeType.ALL], orphanRemoval = true)
//    var trelloCard: MutableSet<TrelloCard> = mutableSetOf()
//)
