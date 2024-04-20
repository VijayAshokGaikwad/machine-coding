package com.example.demo.models.request

import com.example.demo.models.entities.SplitMethod
import jakarta.persistence.*

data class TransactionRequest (
    val spentBy: String,

    val amount: Int,

    val splitMethod: SplitMethod,

    val splitValues: List<Int> = emptyList(),

    val forUsers: List<String> = emptyList()
)
