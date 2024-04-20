package com.example.demo.services

import com.example.demo.models.entities.Users
import com.example.demo.repositories.UserRepository
import org.apache.catalina.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(
    @Autowired private val userRepository: UserRepository,
    ) {

    fun saveUsers(users: List<Users>) {
        userRepository.saveAll(users)
    }

}
