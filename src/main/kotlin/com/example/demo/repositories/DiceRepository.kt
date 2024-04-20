package com.example.demo.repositories

import com.example.demo.models.entities.Dice
import com.example.demo.models.entities.Inventory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiceRepository : JpaRepository<Dice, Long>