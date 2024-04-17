package com.example.demo.services

import com.example.demo.models.entities.Inventory
import com.example.demo.models.request.InventoryRequest
import com.example.demo.repositories.InventoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InventoryService(@Autowired val inventoryRepository: InventoryRepository) {
    fun addInventory(inventoryRequest: InventoryRequest): Long {
        val inventory = Inventory.InventoryBuilder()
            .name(inventoryRequest.name)
            .quantity(inventoryRequest.quantity)
            .build()

        val result = inventoryRepository.save(inventory)

        return result.id
    }

    fun getInventory(): List<Inventory> {
        return inventoryRepository.findAll()
    }

}
