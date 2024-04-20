package com.example.demo.services

import com.example.demo.models.entities.*
import com.example.demo.models.request.TransactionRequest
import com.example.demo.repositories.TransactionParticipantRepository
import com.example.demo.repositories.TransactionRepository
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val transactionRepository: TransactionRepository,
    @Autowired private val transactionParticipantRepository: TransactionParticipantRepository
) {

    fun saveTxns(users: Array<Users>, transactionRequests: List<TransactionRequest>): List<Balance> {
        for (txn in transactionRequests) {
            val payer: Users = userRepository.findByName(txn.spentBy).orElseThrow { Exception("user not found") }

            val transactionId = Math.random().toLong()
            val transaction = Transaction(transactionId, payer, txn.amount, txn.splitMethod, txn.splitValues)

            val listOfTxnPart = mutableListOf<TransactionParticipant>()

            val equalParticipationValue: List<Int> = getParticipationValueForEachUser(txn)

            for ((j, u) in txn.forUsers.withIndex()) {
                val forUser: Users = userRepository.findByName(u).orElseThrow { Exception("user not found") }

                val transactionParticipant = if(forUser.id == payer.id) {
                    TransactionParticipant(
                        Math.random().toLong(), transaction, forUser, 0
                    )
                } else {
                    TransactionParticipant(
                        Math.random().toLong(), transaction, forUser, equalParticipationValue[j]
                    )
                }

                listOfTxnPart.add(transactionParticipant)
            }

            transactionRepository.save(transaction)

            transactionParticipantRepository.saveAll(listOfTxnPart)
        }

        return emptyList()
    }

    fun calculateBalance(): List<Balance> {
        val transactionParticipants = transactionParticipantRepository.findAll()

        val balances = mutableListOf<Balance>()
        val owsMap = HashMap<Pair<Users, Users>, Int>()


        for (txnParticipant in transactionParticipants) {

            val transaction = transactionRepository.findById(txnParticipant.transaction.transactionId)
            val spender = transaction.get().payerId

            if( owsMap.containsKey(txnParticipant.debtorId to spender)) {
                val existingOwedAmount = owsMap[txnParticipant.debtorId to spender]!!

                owsMap[txnParticipant.debtorId to spender] = existingOwedAmount + txnParticipant.amountOwed
            } else {
                owsMap[txnParticipant.debtorId to spender] = txnParticipant.amountOwed
            }
        }

        for (owsInfo in owsMap.entries) {
            val userWhoOws = owsInfo.key.first
            val userToGive = owsInfo.key.second
            val amount = owsInfo.value

            val balance = Balance(Math.random().toLong(), userWhoOws, userToGive, amount)

            balances.add(balance)
        }

        println(balances)

        return balances
    }

    private fun getParticipationValueForEachUser(txn: TransactionRequest): List<Int> {
        val size = txn.forUsers.size
        when(txn.splitMethod) {
            SplitMethod.EQUAL -> {
                val amt = txn.amount / txn.forUsers.size
                return List(size) { amt }
            }
            SplitMethod.EXACT -> {
                return txn.splitValues
            }
            SplitMethod.PERCENT -> {
                val list = mutableListOf<Int>()

                for ((i, tx) in txn.forUsers.withIndex()) {
                    val amt = txn.amount * txn.splitValues[i] / 100
                    list.add(amt)
                }

                return list
            }
        }
    }

}