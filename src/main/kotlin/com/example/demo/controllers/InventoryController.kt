package com.example.demo.controllers

import com.example.demo.models.entities.Inventory
import com.example.demo.models.request.InventoryRequest
import com.example.demo.models.response.InventoryAdditionResponse
import com.example.demo.services.InventoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class InventoryController(@Autowired val inventoryService: InventoryService) {


    @PostMapping("/inventory")
    fun addInventory(@RequestBody inventoryRequest: InventoryRequest): ResponseEntity<InventoryAdditionResponse> {
        val id = inventoryService.addInventory(inventoryRequest)

        return ResponseEntity.ok(InventoryAdditionResponse(id))
    }

    @GetMapping("/inventory")
    fun getInventory(): ResponseEntity<List<Inventory>> {
        val inventory = inventoryService.getInventory()

        return ResponseEntity.ok(inventory)
    }

}