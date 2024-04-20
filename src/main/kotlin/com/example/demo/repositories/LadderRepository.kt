package com.example.demo.repositories

import com.example.demo.models.entities.Inventory
import com.example.demo.models.entities.Ladder
import jakarta.persistence.criteria.From
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface LadderRepository : JpaRepository<Ladder, Long> {
    fun findByFromPosition(fromPosition: Int)  : Optional<Ladder>
}