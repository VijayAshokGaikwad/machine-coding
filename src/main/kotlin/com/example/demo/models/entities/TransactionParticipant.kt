package com.example.demo.models.entities

import jakarta.persistence.*

@Entity
data class TransactionParticipant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id")
    val transaction: Transaction,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "debtor_id", referencedColumnName = "user_id")
    val debtorId: Users,

    val amountOwed: Int,
)

