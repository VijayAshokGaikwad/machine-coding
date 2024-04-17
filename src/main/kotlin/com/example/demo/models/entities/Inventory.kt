package com.example.demo.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Inventory (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,

    val quantity: Int
) {
    class InventoryBuilder {
        private var id: Long = Math.random().toLong()
        private var name: String = ""
        private var quantity: Int = 0

        fun id(id: Long) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun quantity(quantity: Int) = apply { this.quantity = quantity }

        fun build(): Inventory {
            if (name.isEmpty()) {
                throw IllegalStateException("Name cannot be empty")
            }
            return Inventory(id, name, quantity)
        }
    }
}
