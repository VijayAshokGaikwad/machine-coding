package com.example.demo.controllers

import com.example.demo.models.entities.Balance
import com.example.demo.models.entities.SplitMethod
import com.example.demo.models.entities.Users
import com.example.demo.models.request.TransactionRequest
import com.example.demo.services.TransactionService
import com.example.demo.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
open class UserController(
    private var transactionService: TransactionService,
    private var userService: UserService
) {

    @GetMapping("/balance")
    fun getBalance(): ResponseEntity<List<Balance>> {

        val users1 = Users(1, "U1")
        val users2 = Users(2, "U2")
        val users3 = Users(3, "U3")
        val users4 = Users(4, "U4")

        userService.saveUsers(listOf(users1, users2, users3, users4))

        val users = arrayOf(users1, users2, users3, users4)
        val transactionReq = listOf(
            TransactionRequest(users1.name, 1000, SplitMethod.EQUAL, emptyList(), listOf("U1", "U2", "U3", "U4")),
            TransactionRequest(users1.name, 1250, SplitMethod.EXACT, listOf(370, 880), listOf("U2", "U3")),
            TransactionRequest(users4.name, 1200, SplitMethod.PERCENT, listOf(40, 20, 20, 20), listOf("U1", "U2", "U3", "U4")),

        )

        transactionService.saveTxns(users, transactionReq)

        val balance: List<Balance> = transactionService.calculateBalance()

        return ResponseEntity.ok(balance)
    }

}