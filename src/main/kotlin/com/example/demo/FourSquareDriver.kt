package com.example.demo

import com.example.demo.models.entities.CheckIn
import java.io.BufferedReader
import java.io.FileReader
import java.math.BigDecimal
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.stream.Stream


class FourSquareDriver {

    val checkinsData = mutableListOf<CheckIn>()
    private val bReader = BufferedReader(FileReader("dataset_TSMC2014_NYC.csv"))

    fun importFile() {
        var line: String? = bReader.readLine()
        val formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss Z yyyy")

        line = bReader.readLine()

        while (line != null) {
            val lineData: List<String> = Stream.of(line.trim().split(",")).toList().flatten()

            try {
                val zonedDateTime = ZonedDateTime.parse(lineData[7], formatter)
                val timestamp = Timestamp.from(zonedDateTime.toInstant())

                val checkIn = CheckIn(
                    userId = Integer.valueOf(lineData[0]).toLong(),
                    venueId = lineData[1],
                    venueCategoryId = lineData[2],
                    venueCategory = lineData[3],
                    latitude = BigDecimal(lineData[4]),
                    longitude = BigDecimal(lineData[5]),
                    utcTimestamp = timestamp
                )

                checkinsData.add(checkIn)

            } catch (ex: Exception) {
                println("Exception occured ${ex.localizedMessage}")
            }

            line = bReader.readLine()

        }
    }

    fun getMostCheckInsWithin(startTime: Timestamp, endTime: Timestamp): String {
        val venueMostVisited: String = checkinsData.filter {
            it.utcTimestamp > startTime && it.utcTimestamp < endTime
        }.groupBy { it.venueId }
            .mapValues { it.value.size }
            .toList()
            .sortedByDescending { (_, value) -> value }
            .take(1)[0].first

        return venueMostVisited
    }

}

