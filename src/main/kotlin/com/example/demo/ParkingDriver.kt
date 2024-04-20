package com.example.demo

import com.example.demo.models.request.*
import com.example.demo.models.request.VehicleType.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Stream

class ParkingDriver {
    private val bfReader = BufferedReader(InputStreamReader(System.`in`))
    private var parkingLot = ParkingLot("PR1234", mutableListOf())
    private var parkingInfo = mutableListOf<ParkingInfo>()

    fun manageParking() {

        while (true) {
            val inputLine: String = bfReader.readLine().trim()
            val commands: List<String> = Stream.of(inputLine.split(" ")).toList().flatten()

            when (commands[0]) {
                "create_parking_lot" -> {
                    initParkingLot(commands)
                }


                "display" -> {
                    if (commands.size != 3) {
                        throw Exception("Wrong number of commands")
                    }

                    display(commands)
                }


                "park_vehicle" -> {
                    if (commands.size != 4) {
                        throw Exception("Wrong number of commands")
                    }

                    parkVehicle(commands)
                }


                "unpark_vehicle" -> {
                    if (commands.size != 2) {
                        throw Exception("Wrong number of commands")
                    }


                }


                "exit" -> {
                    break
                }
            }


        }

    }

    private fun parkVehicle(commands: List<String>): Pair<Floor, ParkingSlot>? {
        val vType = commands[1]

        for (floor in parkingLot.floors) {

            val available: ParkingSlot? = floor.slots.find {
                it.suitableFor == VehicleType.valueOf(vType) && it.available
            }

            if (available != null) {
                println("Parked in floor - ${floor.id} - slot ${available.id}")

                parkingInfo.add(ParkingInfo(Math.random().toString(), available.id))

                changeAvailabilityOfSlot(available)

                return floor to available
            }
        }

        println("Parking Lot Full")
        return null
    }

    private fun changeAvailabilityOfSlot(available: ParkingSlot) {
        available.available = !available.available
    }

    private fun display(commands: List<String>) {
        val nextCommand = commands[1]
        val vehicleType = valueOf(commands[2])

        when (nextCommand) {
            "free_count" -> {
                val availableSlots: List<Int> = parkingLot.floors.map {
                    it.slots.filter { slot ->
                        slot.available && slot.suitableFor == vehicleType
                    }.size
                }

                availableSlots.mapIndexed { i, slot ->
                    println("No. of free slots for $vehicleType on Floor ${i + 1} : $slot")
                }
            }

            "free_slots" -> {
                val availableSlots: List<List<ParkingSlot>> = parkingLot.floors.map {
                    it.slots.filter { slot ->
                        slot.available && slot.suitableFor == vehicleType
                    }
                }

                availableSlots.mapIndexed { i, slot ->
                    println("Free slots for $vehicleType on Floor ${i + 1} : $slot")
                }
            }

            "occupied_slots" -> {
                val occupiedSlots: List<List<ParkingSlot>> = parkingLot.floors.map {
                    it.slots.filter { slot ->
                        !slot.available && slot.suitableFor == vehicleType
                    }
                }

                occupiedSlots.mapIndexed { i, slot ->
                    println("Occupied slots for $vehicleType on Floor ${i + 1} : $slot")
                }
            }

        }
    }

    private fun initParkingLot(commands: List<String>) {
        if (commands.size != 4) {
            throw Exception("Wrong number of commands")
        }

        val floorsPerLot = Integer.parseInt(commands[2]).toLong()
        val slotsPerFloor = Integer.parseInt(commands[3]).toLong()

        val floors = mutableListOf<Floor>()
        for (j in 1..floorsPerLot) {

            val slots = mutableListOf<ParkingSlot>()
            for (i in 1..slotsPerFloor) {
                val vehicleType = if (i == 1L) TRUCK else if (i <= 3) BIKE else CAR

                slots.add(ParkingSlot(i, vehicleType, true))
            }

            floors.add(Floor(j, slots))
        }

        parkingLot.floors = floors
    }

}
