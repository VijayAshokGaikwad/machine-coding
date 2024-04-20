package com.example.demo.repositories

import com.example.demo.models.entities.Inventory
import com.example.demo.models.entities.Ladder
import com.example.demo.models.entities.Snake
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.swing.text.Position

@Repository
interface SnakeRepository : JpaRepository<Snake, Long> {
    fun findByFromPosition(fromPosition: Int) : Optional<Snake>

}