package com.example.demo.services

import com.example.demo.models.entities.Inventory
import com.example.demo.models.request.InventoryRequest
import com.example.demo.repositories.InventoryRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InventoryServiceTest {

    private val inventoryRepository = mockk<InventoryRepository>()
    private val inventoryService = InventoryService(inventoryRepository = inventoryRepository)

    @Test
    fun `should call repository to add a inventory`() {
        val inventoryRequest = InventoryRequest(name = "Some Product", 10)
        val inventory = Inventory(id = 1, name = "Some Product", 10)

        every { inventoryRepository.save(any()) } returns inventory

        val inventoryId = inventoryService.addInventory(inventoryRequest)

        assert(inventoryId == inventory.id)
    }

    @Test
    fun `should throw error if repository throws error while adding inventory`() {
        val inventoryRequest = InventoryRequest(name = "Some Product", 10)
        val inventory = Inventory(id = 1, name = "Some Product", 10)

        every { inventoryRepository.save(inventory) } throws Exception("Error")

        assertThrows<Exception> {
            inventoryService.addInventory(inventoryRequest)
        }
    }

    @Test
    fun `should call repository to get all products`() {
        val inventory = Inventory(id = 1, name = "Some Product", 10)

        every { inventoryRepository.findAll() } returns listOf(inventory)

        val actual: List<Inventory> = inventoryService.getInventory()

        assert(actual == listOf(inventory))
        verify { inventoryRepository.findAll() }
    }

    @Test
    fun `should throw error if repository throws error while getting products`() {
        every { inventoryRepository.findAll() } throws Exception("Error")

        assertThrows<Exception> {
            inventoryService.getInventory()
        }
    }
}