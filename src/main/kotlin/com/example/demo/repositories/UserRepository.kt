package com.example.demo.repositories

import com.example.demo.models.entities.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository

interface UserRepository : JpaRepository<Users, Long> {
    @Query
    fun findByName(name: String): Optional<Users>
}