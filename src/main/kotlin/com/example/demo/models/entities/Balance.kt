package com.example.demo.models.entities

//@Entity
data class Balance (

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val balanceId: Long,

//    @ManyToOne
//    @JoinColumn(name = "userId")
    val fromUsers: Users,

//    @ManyToOne
//    @JoinColumn(name = "userId")
    val toUsers: Users,

    val amount: Int
)