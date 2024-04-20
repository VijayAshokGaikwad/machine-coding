package com.example.demo.repositories

import com.example.demo.models.entities.TransactionParticipant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface TransactionParticipantRepository : JpaRepository<TransactionParticipant, Long>