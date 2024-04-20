package com.example.demo.models.entities

import jakarta.persistence.*

@Entity
data class Transaction (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val transactionId: Long,

    @ManyToOne
    @JoinColumn(name = "payer_id", referencedColumnName = "user_id")
    val payerId: Users,

    val amount: Int,

    val splitMethod: SplitMethod,

    @ElementCollection
    val splitValues: List<Int> = emptyList()
)
